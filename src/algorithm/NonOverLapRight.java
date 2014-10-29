package algorithm;

import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by math.herbert on 29/10/14.
 */
public class NonOverLapRight {

//    private Rectangle[] rectangles;
//
//    public NonOverLapRight(Rectangle[] rectangles) {
//        this.rectangles = rectangles;
//    }
//
//    public int algo() {
//
//        int passage = 0;
//        int c;
//
//        do {
//            c = execute();
//            passage++;
//            System.out.println("Passage : "+passage);
//            afficherRectangles();
//        }
//        while (c != 0 && c != Integer.MAX_VALUE);
//        //System.out.println("c : "+c);
////        System.out.println("Passage : "+passage);
////        afficherRectangles();
////        while (c != 0 && c != Integer.MAX_VALUE){
////            c = execute();
////            passage++;
////            System.out.println("Passage : "+passage);
////            afficherRectangles();
////        }
//        return c;
//    }
//    public void afficherRectangles(){
//        for(int i = 0; i<rectangles.length; i++){
//            System.out.println(rectangles[i].toString());
//        }
//    }
//    public int execute()  {
//        int c = 0;
//        for(int i = 0; i<rectangles.length;i++){
//            rectangles[i].setFinalX(rectangles[i].getPlacementDomain().getMaxX());
//            Domain domain = new Domain(rectangles[i].getPlacementDomain().getMinX(), rectangles[i].getPlacementDomain().getMaxX(), rectangles[i].getPlacementDomain().getMinY(), rectangles[i].getPlacementDomain().getMaxY());
//            List<Constraint> constraints = new ArrayList<Constraint>();
//            for(int j =0; j<rectangles.length;j++){
//
//                if(j != i){
//                    ForbiddenRegion forbiddenRegion = new ForbiddenRegion();
//                    if(i == 4){
//                        System.out.println("rectangles["+j+"].getPlacementDomain() " + rectangles[j].getPlacementDomain());
//                        System.out.println("rectangles["+i+"].getPlacementDomain().getWidth() " + rectangles[i].getPlacementDomain().getWidth());
//                        System.out.println("rectangles["+i+"].getPlacementDomain().getHeight() " + rectangles[i].getPlacementDomain().getHeight());
//                    }
//                    forbiddenRegion.computeForbiddenRegion(rectangles[j].getPlacementDomain(), rectangles[i].getPlacementDomain().getWidth(), rectangles[i].getPlacementDomain().getHeight());
//
//                    Constraint constraint = new Constraint(domain, ""+i+" "+j);
//                    constraint.addForbiddenRegion(forbiddenRegion);
//                    System.out.println(constraint);
//                    constraints.add(constraint);
//                }
//            }
//            if(checkIfInForbiddenRegion(domain.getMaxX(), rectangles[i].getWitness(), constraints)){
//
//                DataStructure structure = new DataStructure(constraints, domain);
//                SweepMaximumX sweep = new SweepMaximumX(structure);
//                Point point = sweep.findMaximum();
//                //System.out.println("rectangle "+(i+1)+" :" +point);
//                // System.out.println(point.getY());
//                //System.out.println(checkIfInForbiddenRegion(point.getX(), point.getY(), constraints));
//                rectangles[i].setWitness(point.getY());
//                if(point.isR() == false){
//                    return  Integer.MAX_VALUE;
//                }else if(point.getX() != domain.getMaxX()){
//                    if(i == 4){
//                        System.out.println("i " + i);
//                        System.out.println("domain.getMaxX()" + domain.getMaxX());
//                        System.out.println("point.getX()" + point.getX());
//                    }
//                    c++;
//                    rectangles[i].getPlacementDomain().setMaxX(point.getX());
//                    rectangles[i].setFinalX(point.getX());
//                }
//            }
//        }
//        return c;
//    }
//
//    public boolean checkIfInForbiddenRegion(int x, int y, List<Constraint> constraints){
//        if(y == Rectangle.DEFAULT_WITNESS_VALUE){
//            return true;
//        }
//        for (Constraint constraint : constraints){
//            if(constraint.checkIfInForbiddenRegions(x,y)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Rectangle[] getRectangles() {
//        return rectangles;
//    }
}
