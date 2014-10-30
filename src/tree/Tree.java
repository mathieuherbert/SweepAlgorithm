package tree;

import algorithm.Launch;
import algorithm.NonOverLap;
import model.Dimension;
import model.Rectangle;
import sun.misc.Launcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by math.herbert on 30/10/14.
 */
public class Tree {
    private List<Tree> children;

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
        children = new ArrayList<Tree>();

    }

    public void executeTree(){
        Launch launch = new Launch(rectangles,d1,d2);
        try {
            launch.execute();
        }catch (Exception e){
            isOk = false;
            return;
        }
        int min;
        int max;
        if(currentRectangle == rectangles.length-1 && currentDimension == d2){
            isOk = true;
            return;
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
            child.executeTree();
            children.add(child);
        }
    }

    public List<Rectangle[]> getAllPossibilies(){

       if((currentRectangle == rectangles.length-1) && isOk){
           System.out.println("isok!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
          List<Rectangle[]> list = new ArrayList<Rectangle[]>();
           list.add(rectangles);
           return list;
       } else {
           List<Rectangle[]> list = new ArrayList<Rectangle[]>();
           for (Tree child : children){
               list.addAll(child.getAllPossibilies());
           }
           return list;
       }
     //  return new ArrayList<Rectangle[]>();


    }
    public String toString(int level){
        String ret = "child : \n";

        for(Tree child : children){
            for(int i=0; i<level; i++){
                ret+="\t";
            }
            ret+= child.isOk+"  "+child.toString(level+1)+"\n";
        }
        return ret;
    }


    public boolean getIsOk() {
        return isOk;
    }
}
