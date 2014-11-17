package algorithm;

import model.*;
import org.junit.Test;
import tree.Root;
import util.BasicAlgorithm;
import util.Print;
import util.Verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gutii on 17/11/14.
 */
public class ParticularyTest {
    @Test
    public void onePossibilityTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,3);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,3);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(3,3,4);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,0,2);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        InternalValuesPlacementDomain ivp31 = new InternalValuesPlacementDomain(0,0,3);
        InternalValuesPlacementDomain ivp32 = new InternalValuesPlacementDomain(3,3,2);
        HashMap<Dimension, InternalValuesPlacementDomain> h3 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h3.put(Dimension.X, ivp31);
        h3.put(Dimension.Y, ivp32);
        PlacementDomain p3 = new PlacementDomain(h3, Dimension.X, Dimension.Y);
        Rectangle r3 = new Rectangle(p3, "Rectangle 3");

        InternalValuesPlacementDomain ivp41 = new InternalValuesPlacementDomain(6,6,2);
        InternalValuesPlacementDomain ivp42 = new InternalValuesPlacementDomain(2,2,3);
        HashMap<Dimension, InternalValuesPlacementDomain> h4 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h4.put(Dimension.X, ivp41);
        h4.put(Dimension.Y, ivp42);
        PlacementDomain p4 = new PlacementDomain(h4, Dimension.X, Dimension.Y);
        Rectangle r4 = new Rectangle(p4, "Rectangle 4");

        InternalValuesPlacementDomain ivp51 = new InternalValuesPlacementDomain(0,0,8);
        InternalValuesPlacementDomain ivp52 = new InternalValuesPlacementDomain(5,5,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h5 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h5.put(Dimension.X, ivp51);
        h5.put(Dimension.Y, ivp52);
        PlacementDomain p5 = new PlacementDomain(h5, Dimension.X, Dimension.Y);
        Rectangle r5 = new Rectangle(p5, "Rectangle 5");

        InternalValuesPlacementDomain ivp61 = new InternalValuesPlacementDomain(0,6,3);
        InternalValuesPlacementDomain ivp62 = new InternalValuesPlacementDomain(0,5,3);
        HashMap<Dimension, InternalValuesPlacementDomain> h6 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h6.put(Dimension.X, ivp61);
        h6.put(Dimension.Y, ivp62);
        PlacementDomain p6 = new PlacementDomain(h6, Dimension.X, Dimension.Y);
        Rectangle r6 = new Rectangle(p6, "Rectangle 6");

        Rectangle rectangles[] = new Rectangle[6];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;
        rectangles[4] = r5;
        rectangles[5] = r6;

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);

        List<List<Possibility>> algo = root.executeRoot();

        List<List<Possibility>> expectedPossibilities = new ArrayList<List<Possibility>>();
        List<Possibility> expectedPossibility = new ArrayList<Possibility>();

        Possibility poss1 = new Possibility("Rectangle 1",Dimension.X,0,3,Dimension.Y,0,3);
        Possibility poss2 = new Possibility("Rectangle 2",Dimension.X,3,4,Dimension.Y,0,2);
        Possibility poss3 = new Possibility("Rectangle 3",Dimension.X,0,3,Dimension.Y,3,2);
        Possibility poss4 = new Possibility("Rectangle 4",Dimension.X,6,2,Dimension.Y,2,3);
        Possibility poss5 = new Possibility("Rectangle 5",Dimension.X,0,8,Dimension.Y,5,1);
        Possibility poss6 = new Possibility("Rectangle 6",Dimension.X,3,3,Dimension.Y,2,3);

        expectedPossibility.add(poss1);
        expectedPossibility.add(poss2);
        expectedPossibility.add(poss3);
        expectedPossibility.add(poss4);
        expectedPossibility.add(poss5);
        expectedPossibility.add(poss6);

        expectedPossibilities.add(expectedPossibility);

        assertTrue(Verify.samePossibilities(algo,expectedPossibilities));
    }

    @Test
    public void voidTest(){
        Rectangle rectangles[] = new Rectangle[0];

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);
        List<List<Possibility>> algo = root.executeRoot();

        assertEquals(0,algo.size());
    }


    @Test
    public void allPossibilitiesTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,9,1);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,9,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        Rectangle rectangles[] = new Rectangle[1];
        rectangles[0] = r1;

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);

        List<List<Possibility>> algo = root.executeRoot();
        BasicAlgorithm sauvage = new BasicAlgorithm();
        List<List<Possibility>> resultSauvage = sauvage.basicAlgorithm(rectangles);

        assertTrue(Verify.samePossibilities(resultSauvage, algo));
    }

    @Test
    public void placementLeftTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(2,2,2);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,5);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(-2,3,4);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,0,2);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        Rectangle rectangles[] = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);

        List<List<Possibility>> algo = root.executeRoot();
        BasicAlgorithm sauvage = new BasicAlgorithm();
        List<List<Possibility>> resultSauvage = sauvage.basicAlgorithm(rectangles);

        assertTrue(Verify.samePossibilities(resultSauvage, algo));
    }

    @Test
    public void placementRightTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(2,2,2);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,5);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(2,4,4);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,0,2);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        Rectangle rectangles[] = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);

        List<List<Possibility>> algo = root.executeRoot();
        BasicAlgorithm sauvage = new BasicAlgorithm();
        List<List<Possibility>> resultSauvage = sauvage.basicAlgorithm(rectangles);

        assertTrue(Verify.samePossibilities(resultSauvage, algo));
    }

    @Test
    public void placementTopTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(2,2,2);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,5);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(2,2,4);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,5,2);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        Rectangle rectangles[] = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);

        List<List<Possibility>> algo = root.executeRoot();
        BasicAlgorithm sauvage = new BasicAlgorithm();
        List<List<Possibility>> resultSauvage = sauvage.basicAlgorithm(rectangles);

        assertTrue(Verify.samePossibilities(resultSauvage, algo));
    }

    @Test
    public void placementBottomTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(2,2,2);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,5);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(2,2,4);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(-2,4,2);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        Rectangle rectangles[] = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;

        Root root = new Root(rectangles,Dimension.X, Dimension.Y);

        List<List<Possibility>> algo = root.executeRoot();
        BasicAlgorithm sauvage = new BasicAlgorithm();
        List<List<Possibility>> resultSauvage = sauvage.basicAlgorithm(rectangles);

        assertTrue(Verify.samePossibilities(resultSauvage, algo));
    }
}
