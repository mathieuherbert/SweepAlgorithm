package tree;

import model.Dimension;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by math.herbert on 30/10/14.
 */
public class Root {

    private List<Tree> children;

    private Rectangle[] rectangles;

    private Dimension d1;

    private Dimension d2;

    public Root(Rectangle[] rectangles, Dimension d1, Dimension d2) {
        this.rectangles = rectangles;
        this.d1 = d1;
        this.d2 = d2;
        children = new ArrayList<Tree>();
    }

    public void executeRoot(){

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
            Tree child = new Tree(rectanglesTmp,d1,d2,0,d1);
            child.executeTree();
            children.add(child);
        }
    }

    public List<Rectangle[]> getAllPossibilities(){
        executeRoot();
        List<Rectangle[]> list =new ArrayList<Rectangle[]>();
        for(Tree child : children){
            list.addAll(child.getAllPossibilies());
        }
        int count =1;
        for(Rectangle[] rectangles1 : list){
            System.out.println("Nouvelle solution ("+count+"): ");
            for(Rectangle rectangleb : rectangles1){
                System.out.println(rectangleb.toString()+"\n");
            }
            System.out.println("\n\n\n");
            count++;
        }
        System.out.println("Nombre de solution : "+list.size());
        return  list;
    }

    public String toString(){
        String ret = "root : \n";
        for(Tree child : children)
            ret+=child.getIsOk()+" "+ child.toString(1);
        return ret;
    }
}