package tree;

import algorithm.Launch;
import model.Dimension;
import model.Possibility;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * The root of the tree
 */
public class Root {



    private Rectangle[] rectangles;

    private Dimension d1;

    private Dimension d2;

    /**
     *
     * @param rectangles
     * @param d1 first dimension
     * @param d2 second dimension
     */
    public Root(Rectangle[] rectangles, Dimension d1, Dimension d2) {
        this.rectangles = rectangles;
        this.d1 = d1;
        this.d2 = d2;

    }

    /**
     *
     * @return the different possibilies of NonOverlap rectangles
     */
    public List<List<Possibility>> executeRoot(){
        List<List<Possibility>> possibilities = new ArrayList<List<Possibility>>();
        //execute the nonOverLap for the first time
        Launch launch = new Launch(rectangles,d1,d2);
        try {
            launch.execute();
        } catch (Exception e) {

        }
        Rectangle rectangle = rectangles[0];
        int max = rectangle.getPlacementDomain().getPlacement(d1).getMax();
        int min = rectangle.getPlacementDomain().getPlacement(d1).getMin();

        for(int i =min; i<=max; i++){

            Rectangle[] rectanglesTmp = new Rectangle[rectangles.length];
            for(int j=0; j<rectangles.length; j++){
                rectanglesTmp[j] = new Rectangle(rectangles[j]);
            }
            rectanglesTmp[0].getPlacementDomain().getPlacement(d1).setMin(i);
            rectanglesTmp[0].getPlacementDomain().getPlacement(d1).setMax(i);
            possibilities.addAll(new Tree().executeTree(rectanglesTmp,d1,d2,0,d1));
        }
        return  possibilities;
    }
}
