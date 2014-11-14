package algorithm;

import model.*;
import org.junit.Test;
import tree.Root;
import util.BasicAlgorithm;
import util.Verify;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by math.herbert on 14/11/14.
 */
public class NoPossibilitiesTest {
    @Test
    public void noPossibilities2RectanglesInSamePosition(){
        Rectangle[] rectanglesInit = new Rectangle[2];
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,8);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1, Dimension.X, Dimension.Y);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");


        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,0,8);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        rectanglesInit[0] = r1;
        rectanglesInit[1] = r2;

        Root root = new Root(rectanglesInit,Dimension.X,Dimension.Y);
        List<List<Possibility>> possibilities = root.executeRoot();
        assertEquals(0,possibilities.size());
    }


    @Test
    public void noPossibilities2RectanglesInTheSamePlacement(){
        Rectangle[] rectanglesInit = new Rectangle[2];
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,4,8);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1, Dimension.X, Dimension.Y);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");


        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,4,8);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        rectanglesInit[0] = r1;
        rectanglesInit[1] = r2;

        Root root = new Root(rectanglesInit,Dimension.X,Dimension.Y);
        List<List<Possibility>> possibilities = root.executeRoot();
        assertEquals(0,possibilities.size());
    }


    @Test
    public void noPossibilities2RectanglesOneInAnother(){
        Rectangle[] rectanglesInit = new Rectangle[2];
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,4);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,4);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1, Dimension.X, Dimension.Y);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");


        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,3,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,3,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        rectanglesInit[0] = r1;
        rectanglesInit[1] = r2;

        Root root = new Root(rectanglesInit,Dimension.X,Dimension.Y);
        List<List<Possibility>> possibilities = root.executeRoot();
        assertEquals(0,possibilities.size());
    }


    @Test
    public void noPossibilities2RectanglesOneInAnotherWithBasicAlgorithm(){
        Rectangle[] rectanglesInit = new Rectangle[2];
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,4);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,4);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1, Dimension.X, Dimension.Y);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");


        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,3,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,3,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        rectanglesInit[0] = r1;
        rectanglesInit[1] = r2;

        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = new Rectangle(r1);
        rectangles[1] = new Rectangle(r2);
        Root root = new Root(rectanglesInit,Dimension.X,Dimension.Y);
        List<List<Possibility>> possibilities = root.executeRoot();
        assertTrue(Verify.samePossibilities(new BasicAlgorithm().basicAlgorithm(rectangles), possibilities));
    }


}
