package tree;

import algorithm.Launch;
import algorithm.NonOverLap;
import model.Dimension;
import model.Possibility;
import model.Rectangle;
import sun.misc.Launcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Other parts of the tree
 */
public class Tree {


    public Tree() {

    }

    /**
     * get All Possibilities for NonOverlap over 2 dimensions
     * @param rectangles
     * @param d1 first dimension
     * @param d2 second dimension
     * @param currentRectangle the current rectangle
     * @param currentDimension the first or second dimension
     * @return all possibilities
     */
    public List<List<Possibility>> executeTree(Rectangle[] rectangles, Dimension d1, Dimension d2, int currentRectangle, Dimension currentDimension){

        Launch launch = new Launch(rectangles,d1,d2);
        try {
            launch.execute();
        }catch (Exception e){
            //no one possibilities
            return new ArrayList<List<Possibility>>();
        }
        int min;
        int max;
        //it is the last rectangle and last dimension => and there is a possibility
        if(currentRectangle == rectangles.length-1 && currentDimension == d2){
            List<List<Possibility>> possibilities = new ArrayList<List<Possibility>>();
            List<Possibility> tmp = new ArrayList<Possibility>();
            //create possibilities
            for(Rectangle rectangleb : rectangles){
                tmp.add(new Possibility(rectangleb.getName(),
                        rectangleb.getPlacementDomain().getD1(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD1()).getMin(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD1()).getWidth(),
                        rectangleb.getPlacementDomain().getD2(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD2()).getMin(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD2()).getWidth()));


            }
            possibilities.add(tmp);
            return possibilities;
        }
        //swap dimension or go to next rectangle
        if(currentDimension == d2){
            Rectangle rectangle = rectangles[currentRectangle+1];
            max = rectangle.getPlacementDomain().getPlacement(d1).getMax();
            min = rectangle.getPlacementDomain().getPlacement(d1).getMin();
        }else {
            Rectangle rectangle = rectangles[currentRectangle];
            max = rectangle.getPlacementDomain().getPlacement(d2).getMax();
            min = rectangle.getPlacementDomain().getPlacement(d2).getMin();
        }
        List<List<Possibility>> possibilities = new ArrayList<List<Possibility>>();

        for(int i =min; i<=max; i++){
            Rectangle[] rectanglesTmp = new Rectangle[rectangles.length];
            for(int j=0; j<rectangles.length; j++){
                rectanglesTmp[j] = new Rectangle(rectangles[j]);
            }

            if(currentDimension == d1){
                rectanglesTmp[currentRectangle].getPlacementDomain().getPlacement(d2).setMin(i);
                rectanglesTmp[currentRectangle].getPlacementDomain().getPlacement(d2).setMax(i);
                possibilities.addAll(executeTree(rectanglesTmp, d1, d2, currentRectangle, d2));
            } else{
                rectanglesTmp[currentRectangle+1].getPlacementDomain().getPlacement(d1).setMin(i);
                rectanglesTmp[currentRectangle+1].getPlacementDomain().getPlacement(d1).setMax(i);
                possibilities.addAll(executeTree(rectanglesTmp, d1, d2, currentRectangle + 1, d1));
            }
        }
        //there are no one possibility
        return  possibilities;
    }


}
