package util;

import model.Dimension;
import model.Possibility;
import model.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic algorithm to compute NonOverLap rectangles
 */
public class BasicAlgorithm {
    /**
     *
     * @param rectangles list of rectangles to compute
     * @return the list of possibilities of correct positions
     */
    public List<List<Possibility>> basicAlgorithm(Rectangle rectangles[]){
        return getPossibilities(rectangles, new ArrayList<Possibility>(), -1);
    }

    /**
     *
      * @param rectangles list of rectangles to compute
     * @param beginning the possibilities in which rectangles are already fixed
     * @param current the current recantgle to fix
     * @return the list of possibilities of correct positions
     */
    private List<List<Possibility>> getPossibilities(Rectangle rectangles[], List<Possibility> beginning, int current){
        List<List<Possibility>> possibilities = new ArrayList<List<Possibility>>();
        current++;
        Dimension d1 = rectangles[current].getPlacementDomain().getD1();
        Dimension d2 = rectangles[current].getPlacementDomain().getD2();
        int d1Min = rectangles[current].getPlacementDomain().getPlacement(d1).getMin();
        int d1Max = rectangles[current].getPlacementDomain().getPlacement(d1).getMax();
        int d1width = rectangles[current].getPlacementDomain().getPlacement(d1).getWidth();
        int d2Min = rectangles[current].getPlacementDomain().getPlacement(d2).getMin();
        int d2Max = rectangles[current].getPlacementDomain().getPlacement(d2).getMax();
        int d2width = rectangles[current].getPlacementDomain().getPlacement(d2).getWidth();
        for(int i = d1Min; i<=d1Max; i++){
            for(int j = d2Min; j<=d2Max; j++){
                Possibility tmp = new Possibility(
                        rectangles[current].getName(),d1, i,d1width,
                        d2, j,d2width);
                boolean nonOverlap = true;
                for(int k = 0; k<beginning.size(); k++){
                    if(overlap(beginning.get(k), tmp)){
                        nonOverlap = false;
                    }
                }
                if(nonOverlap == false){
                    continue;
                    //new possibility is a valid possibility
                }else {
                    List<Possibility> currentPossibilities = new ArrayList<Possibility>();
                    for(int k = 0; k<beginning.size(); k++){
                        currentPossibilities.add(new Possibility(beginning.get(k)));
                    }
                    currentPossibilities.add(tmp);
                    if(current == rectangles.length-1){
                        possibilities.add(currentPossibilities);
                    }else{
                        possibilities.addAll(getPossibilities(rectangles, currentPossibilities, current));
                    }
                }
            }
        }
        return possibilities;
    }

    public static boolean overlap(Possibility possibilityPlaced, Possibility toPlaced )
    {
        // If one rectangle is on right side of other
        if (toPlaced.getD1Value() > possibilityPlaced.getD1Value()+possibilityPlaced.getD1Width()-1 || possibilityPlaced.getD1Value() > toPlaced.getD1Value()+toPlaced.getD1Width()-1 )
            return false;
        // If one rectangle is above other
        if (toPlaced.getD2Value() > possibilityPlaced.getD2Value()+possibilityPlaced.getD2Width()-1 || possibilityPlaced.getD2Value() > toPlaced.getD2Value()+toPlaced.getD2Width()-1 )
            return false;

        return true;
    }
}
