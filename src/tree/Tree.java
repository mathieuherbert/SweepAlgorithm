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
 * Created by math.herbert on 30/10/14.
 */
public class Tree {


    private Rectangle[] rectangles;

    private Dimension d1;

    private Dimension d2;

    private boolean isOk;

    private int currentRectangle;

    private Dimension currentDimension;



    public Tree(Rectangle[] rectangles, Dimension d1, Dimension d2, int currentRectangle, Dimension currentDimension) {
        this.rectangles = rectangles;
        this.d1 = d1;
        this.d2 = d2;
        this.currentRectangle = currentRectangle;
        this.currentDimension = currentDimension;
        isOk = false;


    }

    public List<List<Possibility>> executeTree(){
        /*System.out.println("rectangles[0].getName() = " + rectangles[currentRectangle].getName());
        System.out.println("dim = " +currentDimension);
        System.out.println("d1 : "+rectangles[currentRectangle].getPlacementDomain().getPlacement(rectangles[currentRectangle].getPlacementDomain().getD1()).getMin());
        System.out.println("d2 : "+rectangles[currentRectangle].getPlacementDomain().getPlacement(rectangles[currentRectangle].getPlacementDomain().getD2()).getMin());*/

        Launch launch = new Launch(rectangles,d1,d2);
        try {
            launch.execute();
        }catch (Exception e){
            isOk = false;
            return new ArrayList<List<Possibility>>();
        }
        int min;
        int max;
        if(currentRectangle == rectangles.length-1 && currentDimension == d2){
            isOk = true;
            List<List<Possibility>> possibilities = new ArrayList<List<Possibility>>();
            List<Possibility> tmp = new ArrayList<Possibility>();

            for(Rectangle rectangleb : rectangles){
                tmp.add(new Possibility(rectangleb.getName(),
                        rectangleb.getPlacementDomain().getD1(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD1()).getMin(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD1()).getWidth(),
                        rectangleb.getPlacementDomain().getD2(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD2()).getMin(),
                        rectangleb.getPlacementDomain().getPlacement(rectangleb.getPlacementDomain().getD2()).getWidth()));

                //System.out.println(rectangleb.toString() + "\n");
            }
            //System.out.println("\n\n\n");
            //count++;
            possibilities.add(tmp);

            return possibilities;
        }
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
            Tree child = null;
            if(currentDimension == d1){
                rectanglesTmp[currentRectangle].getPlacementDomain().getPlacement(d2).setMin(i);
                rectanglesTmp[currentRectangle].getPlacementDomain().getPlacement(d2).setMax(i);
                child = new Tree(rectanglesTmp,d1,d2,currentRectangle,d2);
            } else{
                rectanglesTmp[currentRectangle+1].getPlacementDomain().getPlacement(d1).setMin(i);
                rectanglesTmp[currentRectangle+1].getPlacementDomain().getPlacement(d1).setMax(i);
                child = new Tree(rectanglesTmp,d1,d2,currentRectangle+1,d1);
            }
            possibilities.addAll(child.executeTree());

        }
        return  possibilities;
    }

    public boolean getIsOk() {
        return isOk;
    }
}
