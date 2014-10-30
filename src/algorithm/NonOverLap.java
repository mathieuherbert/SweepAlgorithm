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

    public int algo() {

        int passage = 0;
        int c;

        do {
            c = execute();
            passage++;
            System.out.println("Passage : "+passage);
            afficherRectangles();
        }
        while (c != 0 && c != Integer.MAX_VALUE);
        //System.out.println("c : "+c);
//        System.out.println("Passage : "+passage);
//        afficherRectangles();
//        while (c != 0 && c != Integer.MAX_VALUE){
//            c = execute();
//            passage++;
//            System.out.println("Passage : "+passage);
//            afficherRectangles();
//        }
        return c;
    }
    public void afficherRectangles(){
        for(int i = 0; i<rectangles.length; i++){
            System.out.println(rectangles[i].toString());
        }
    }
    public int execute()  {
        int c = 0;
        for(int i = 0; i<rectangles.length;i++){

            rectangles[i].setFinalExternal(isMax?rectangles[i].getPlacementDomain().getPlacement(external).getMax():rectangles[i].getPlacementDomain().getPlacement(external).getMin());
            System.out.println("i : "+i+"  "+rectangles[i].getFinalExternal());
            InternalValuesDomain externalValues = new InternalValuesDomain(rectangles[i].getPlacementDomain().getPlacement(external).getMin(), rectangles[i].getPlacementDomain().getPlacement(external).getMax());
            InternalValuesDomain internalValues = new InternalValuesDomain(rectangles[i].getPlacementDomain().getPlacement(internal).getMin(), rectangles[i].getPlacementDomain().getPlacement(internal).getMax());
            HashMap<Dimension,InternalValuesDomain> dimensions= new HashMap<Dimension,InternalValuesDomain>();
            dimensions.put(external,externalValues);
            dimensions.put(internal,internalValues);
            Domain domain = new Domain(dimensions);
            List<Constraint> constraints = new ArrayList<Constraint>();
            for(int j =0; j<rectangles.length;j++){

                if(j != i){
                    ForbiddenRegion forbiddenRegion = new ForbiddenRegion();
                    System.out.println("rectangles["+j+"].getPlacementDomain() " + rectangles[j].getPlacementDomain());
                    System.out.println("rectangles["+i+"].getPlacementDomain().getWidth() " + rectangles[i].getPlacementDomain().getPlacement(external).getWidth());
                    System.out.println("rectangles["+i+"].getPlacementDomain().getHeight() " + rectangles[i].getPlacementDomain().getPlacement(internal).getWidth());
                    forbiddenRegion.computeForbiddenRegion(rectangles[j].getPlacementDomain(), rectangles[i].getPlacementDomain().getPlacement(external).getWidth(), rectangles[i].getPlacementDomain().getPlacement(internal).getWidth());
                    Constraint constraint = new Constraint(domain, ""+i+" "+j);
                    constraint.addForbiddenRegion(forbiddenRegion);
                    System.out.println(constraint);
                    constraints.add(constraint);
                }
                if(i==4 && j == 2){
                    System.out.println("ici");
                }
            }
            if(checkIfInForbiddenRegion(domain.getValue(external,isMax), rectangles[i].getWitness(), constraints)){
                DataStructure structure = new DataStructure(constraints, domain);
                Sweep sweep = new Sweep(structure, internal, external,isMax);
                Point point = sweep.find();
                //System.out.println("rectangle "+(i+1)+" :" +point);
                // System.out.println(point.getY());
                //System.out.println(checkIfInForbiddenRegion(point.getX(), point.getY(), constraints));
                rectangles[i].setWitness(point.getInternal());
                if(point.isR() == false){
                    return  Integer.MAX_VALUE;
                }else if(point.getExternal() != domain.getValue(external,isMax)){
                    System.out.println("i " + i);
                    System.out.println("domain.getValue" + domain.getValue(external,isMax));
                    System.out.println("point.getX()" + point.getExternal());
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
