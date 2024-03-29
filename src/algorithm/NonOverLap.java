package algorithm;

import model.*;
import model.Dimension;
import model.Point;
import model.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by math.herbert on 29/10/14.
 */
public class NonOverLap {
    private Rectangle[] rectangles;
    private boolean isMax;
    private Dimension external;
    private Dimension internal;
    public NonOverLap(Rectangle[] rectangles, boolean isMax, Dimension external, Dimension internal) {
        this.rectangles = rectangles;
        this.isMax = isMax;
        this.external = external;
        this.internal = internal;
    }

    public int execute()  {
        int c = 0;
        for(int i = 0; i<rectangles.length;i++){
            //init min or max the final walue
            rectangles[i].setFinalExternal(isMax?rectangles[i].getPlacementDomain().getPlacement(external).getMax():rectangles[i].getPlacementDomain().getPlacement(external).getMin());

            //create data about the current regtangle
            InternalValuesDomain externalValues = new InternalValuesDomain(rectangles[i].getPlacementDomain().getPlacement(external).getMin(), rectangles[i].getPlacementDomain().getPlacement(external).getMax());
            InternalValuesDomain internalValues = new InternalValuesDomain(rectangles[i].getPlacementDomain().getPlacement(internal).getMin(), rectangles[i].getPlacementDomain().getPlacement(internal).getMax());
            HashMap<Dimension,InternalValuesDomain> dimensions= new HashMap<Dimension,InternalValuesDomain>();
            dimensions.put(external,externalValues);
            dimensions.put(internal,internalValues);
            Domain domain = new Domain(dimensions);
            //create constraints of the current rectangles over the others
            List<Constraint> constraints = new ArrayList<Constraint>();
            for(int j =0; j<rectangles.length;j++){

                if(j != i){
                    ForbiddenRegion forbiddenRegion = new ForbiddenRegion();
                    forbiddenRegion.computeForbiddenRegion(rectangles[j].getPlacementDomain(), rectangles[i].getPlacementDomain().getPlacement(external).getWidth(), rectangles[i].getPlacementDomain().getPlacement(internal).getWidth());
                    Constraint constraint = new Constraint(domain, ""+i+" "+j);
                    constraint.addForbiddenRegion(forbiddenRegion);
                    constraints.add(constraint);
                }

            }
            //if the rectangle is on a forbidden region we need to use sweep algorithm
            if(checkIfInForbiddenRegion(domain.getValue(external,isMax), rectangles[i].getWitness(), constraints)){
                DataStructure structure = new DataStructure(constraints, domain);
                Sweep sweep = new Sweep(structure, internal, external,isMax);
                Point point = sweep.find();
                rectangles[i].setWitness(point.getInternal());
                if(point.isR() == false){

                    return  Integer.MAX_VALUE;
                }else if(point.getExternal() != domain.getValue(external,isMax)){

                    c++;
                    if(isMax)
                        rectangles[i].getPlacementDomain().getPlacement(external).setMax(point.getExternal());
                    else
                        rectangles[i].getPlacementDomain().getPlacement(external).setMin(point.getExternal());
                    rectangles[i].setFinalExternal(point.getExternal());
                }
            }
        }
        return c;
    }

    public boolean checkIfInForbiddenRegion(int x, int y, List<Constraint> constraints){
        if(y == Rectangle.DEFAULT_WITNESS_VALUE){
            return true;
        }
        for (Constraint constraint : constraints){
            if(constraint.checkIfInForbiddenRegions(x,y)){
                return true;
            }
        }
        return false;
    }

    public Rectangle[] getRectangles() {
        return rectangles;
    }
}
