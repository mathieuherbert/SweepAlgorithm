package tree;

import model.Dimension;
import model.Possibility;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by math.herbert on 30/10/14.
 */
public class Root {



    private Rectangle[] rectangles;

    private Dimension d1;

    private Dimension d2;

    public Root(Rectangle[] rectangles, Dimension d1, Dimension d2) {
        this.rectangles = rectangles;
        this.d1 = d1;
        this.d2 = d2;

    }

    public List<List<Possibility>> executeRoot(){
        List<List<Possibility>> possibilities = new ArrayList<List<Possibility>>();

        Rectangle rectangle = rectangles[0];
        int max = rectangle.getPlacementDomain().getPlacement(d1).getMax();
        int min = rectangle.getPlacementDomain().getPlacement(d1).getMin();

        for(int i =min; i<=max; i++){
           /* System.out.println("rectangles[0].getName() = " + rectangles[0].getName());
            System.out.println("d1 = " + d1);*/
            Rectangle[] rectanglesTmp = new Rectangle[rectangles.length];
            for(int j=0; j<rectangles.length; j++){
                rectanglesTmp[j] = new Rectangle(rectangles[j]);
            }
            rectanglesTmp[0].getPlacementDomain().getPlacement(d1).setMin(i);
            rectanglesTmp[0].getPlacementDomain().getPlacement(d1).setMax(i);
            Tree child = new Tree(rectanglesTmp,d1,d2,0,d1);
            possibilities.addAll(child.executeTree());
        }
        return  possibilities;
    }
}
