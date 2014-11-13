package algorithm;

import model.*;
import org.junit.Test;
import tree.Root;
import util.Print;
import util.Verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by math.herbert on 13/11/14.
 */
public class AllPossibilitiesTest {

    @Test
    public void bigBigTest(){
        int nbRectangles =50;


        Rectangle[][] rectanglesInit = new Rectangle[2][];

        rectanglesInit[0] = new Rectangle[nbRectangles];
        rectanglesInit[1] = new Rectangle[nbRectangles];
        for(int i = 0; i<nbRectangles; i++){
            int v1 = (int)(Math.random()*100.0)+1;
            int v2 = (int)(Math.random()*5.0)+v1;
            int v3 = (int)(Math.random()*100.0)+1;
            int v4 = (int)(Math.random()*5.0)+v3;

            int width1 = (int)(Math.random()*10.0)+1;
            int width2 = (int)(Math.random()*10.0)+1;
            for(int k = 0; k<2;k++){
            InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(v1,v2,width1);
                InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(v3,v4,width2);
                HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
                h1.put(Dimension.X, ivp11);
                h1.put(Dimension.Y, ivp12);
                PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
                Rectangle r = new Rectangle(p1, "Rectangle "+i);
                rectanglesInit[k][i] = r;
            }
        }



        Root root = new Root(rectanglesInit[1],Dimension.X, Dimension.Y);
        long startTime = System.nanoTime();
        List<List<Possibility>> sauvage = null;
        List<List<Possibility>> algo = root.executeRoot();

        long finalTime = System.nanoTime();
        System.out.println("Algo : "+ (finalTime-startTime));
        startTime = System.nanoTime();
        sauvage = basicAlgorithm(rectanglesInit[0]);
        finalTime = System.nanoTime();
        System.out.println("Basic : "+ (finalTime-startTime));

        try {
            Print.printPossibilites(Verify.areNotInP2(sauvage, algo));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(Verify.samePossibilities(sauvage, algo));
    }


    @Test
    public void bigTest(){

        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(1,4,2);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(2,4,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(4,4,3);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(6,6,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        InternalValuesPlacementDomain ivp31 = new InternalValuesPlacementDomain(2,4,1);
        InternalValuesPlacementDomain ivp32 = new InternalValuesPlacementDomain(8,9,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h3 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h3.put(Dimension.X, ivp31);
        h3.put(Dimension.Y, ivp32);
        PlacementDomain p3 = new PlacementDomain(h3, Dimension.X, Dimension.Y);
        Rectangle r3 = new Rectangle(p3, "Rectangle 3");

        InternalValuesPlacementDomain ivp41 = new InternalValuesPlacementDomain(7,7,1);
        InternalValuesPlacementDomain ivp42 = new InternalValuesPlacementDomain(1,1,3);
        HashMap<Dimension, InternalValuesPlacementDomain> h4 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h4.put(Dimension.X, ivp41);
        h4.put(Dimension.Y, ivp42);
        PlacementDomain p4 = new PlacementDomain(h4, Dimension.X, Dimension.Y);
        Rectangle r4 = new Rectangle(p4, "Rectangle 4");

        InternalValuesPlacementDomain ivp51 = new InternalValuesPlacementDomain(1,7,5);
        InternalValuesPlacementDomain ivp52 = new InternalValuesPlacementDomain(1,8,4);
        HashMap<Dimension, InternalValuesPlacementDomain> h5 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h5.put(Dimension.X, ivp51);
        h5.put(Dimension.Y, ivp52);
        PlacementDomain p5 = new PlacementDomain(h5, Dimension.X, Dimension.Y);
        Rectangle r5 = new Rectangle(p5, "Rectangle 5");

        Rectangle rectangles[] = new Rectangle[5];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;
        rectangles[4] = r5;

        Rectangle rectanglesBasic[] = new Rectangle[5];
        rectanglesBasic[0] = new Rectangle(r1);
        rectanglesBasic[1] = new Rectangle(r2);
        rectanglesBasic[2] = new Rectangle(r3);
        rectanglesBasic[3] = new Rectangle(r4);
        rectanglesBasic[4] = new Rectangle(r5);

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);
        long startTime = System.nanoTime();
        List<List<Possibility>> sauvage = basicAlgorithm(rectanglesBasic);
        long finalTime = System.nanoTime();
        System.out.println("Basic : "+ (finalTime-startTime));
        startTime = System.nanoTime();
        List<List<Possibility>> algo = root.executeRoot();
        finalTime = System.nanoTime();
        System.out.println("Algo : "+ (finalTime-startTime));

        try {
           Print.printPossibilites(Verify.areNotInP2(sauvage, algo));
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(Verify.samePossibilities(sauvage, algo));
    }

    @Test
    public void basicTest(){

        Rectangle[] rectanglesInit = new Rectangle[3];
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,8);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1, Dimension.X, Dimension.Y);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");


        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,1,4);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,7,4);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        InternalValuesPlacementDomain ivp31 = new InternalValuesPlacementDomain(0,1,4);
        InternalValuesPlacementDomain ivp32 = new InternalValuesPlacementDomain(0,7,4);
        HashMap<Dimension, InternalValuesPlacementDomain> h3 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h3.put(Dimension.X, ivp31);
        h3.put(Dimension.Y, ivp32);
        PlacementDomain p3 = new PlacementDomain(h3, Dimension.X, Dimension.Y);
        Rectangle r3 = new Rectangle(p3, "Rectangle 3");
        rectanglesInit[0] = r1;
        rectanglesInit[1] = r2;
        rectanglesInit[2] = r3;

        Root root = new Root(rectanglesInit,Dimension.X, Dimension.Y);
        long startTime = System.nanoTime();
        List<List<Possibility>> sauvage = basicAlgorithm(rectanglesInit);
        long finalTime = System.nanoTime();
        System.out.println("Basic : "+ (finalTime-startTime));
        startTime = System.nanoTime();
        List<List<Possibility>> algo = root.executeRoot();
        finalTime = System.nanoTime();
        System.out.println("Algo : "+ (finalTime-startTime));
        try {
            System.out.println(Verify.areNotInP2(sauvage, algo).size());
        } catch (Exception e) {
            e.printStackTrace();
        }
       assertTrue(Verify.samePossibilities(sauvage,algo));
    }
    public List<List<Possibility>> basicAlgorithm(Rectangle rectangles[]){
        return getPossibilities(rectangles, new ArrayList<Possibility>(), -1);
    }

    public List<List<Possibility>> getPossibilities(Rectangle rectangles[], List<Possibility> beginning, int current){
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
                        break;
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
