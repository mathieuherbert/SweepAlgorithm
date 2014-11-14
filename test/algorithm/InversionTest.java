package algorithm;

import model.*;
import org.junit.Test;
import tree.Root;
import util.Print;
import util.Verify;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by math.herbert on 12/11/14.
 * Test multiple tests with different order
 */
public class InversionTest {
    @Test
    public void testExecuteSmallTest() throws Exception {
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
        List<List<Possibility>> previous = null;
        for(int i = 0; i< 3; i++){

            Rectangle rectangles[] = new Rectangle[3];
            for(int j=0; j< (3-i) ; j++){
                rectangles[j+i] = rectanglesInit[j];
            }

            for(int j = (3-i); j<3; j++ ){
                rectangles[2-j] = rectanglesInit[j];
            }
            for(int j = 0; j<3; j++ ){
                System.out.println("rectangles : "+ rectangles[j].getName());
            }
            Root root = new Root(rectangles,Dimension.X, Dimension.Y);
            List<List<Possibility>> current = root.executeRoot();
            if(previous != null){
                assertTrue(Verify.samePossibilities(previous,current));
            }
            previous = current;

        }
    }
    @Test
    public void testExecuteBigTest() throws Exception {
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
        Rectangle rectanglesInit[] = new Rectangle[5];

            rectanglesInit[0] = r1;
            rectanglesInit[1] = r2;
            rectanglesInit[2] = r3;
            rectanglesInit[3] = r4;
            rectanglesInit[4] = r5;
        List<List<Possibility>> previous = null;
        for(int i = 0; i< 5; i++){

            Rectangle rectangles[] = new Rectangle[5];
            for(int j=0; j< (5-i) ; j++){
                rectangles[j+i] = rectanglesInit[j];
            }

            for(int j = (5-i); j<5; j++ ){
                rectangles[4-j] = rectanglesInit[j];
            }
            for(int j = 0; j<5; j++ ){
                System.out.println("rectangles : "+ rectangles[j].getName());
            }
            Root root = new Root(rectangles,Dimension.X, Dimension.Y);
            List<List<Possibility>> current = root.executeRoot();
            if(previous != null){
                System.out.println("current.size() = " + current.size());
                Print.printPossibilites(Verify.areNotInP2(current,previous));
                assertTrue(Verify.samePossibilities(previous,current));
            }
            previous = current;

        }
    }
 }
