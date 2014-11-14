package algorithm;

import model.Dimension;
import model.InternalValuesPlacementDomain;
import model.PlacementDomain;
import model.Rectangle;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by math.herbert on 14/11/14.
 */
public class NonOverLapTest {
    @Test
    public void nonOverLapLeftTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,6);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,6);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,6,3);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,0,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;


        NonOverLap nf = new NonOverLap(rectangles, false, Dimension.X, Dimension.Y);
        nf.execute();
        assertEquals(0, rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMax());

        assertEquals(6,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(6,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMax());

    }

    @Test
    public void nonOverLapRightTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(6,6,6);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,6);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,9,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,0,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;


        NonOverLap nr = new NonOverLap(rectangles, true, Dimension.X, Dimension.Y);
        nr.execute();
        assertEquals(6, rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(6,rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMax());

        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(5,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMax());
    }
    @Test
    public void nonOverLapBottomTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,6);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,6);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,6,3);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;

        r1.getPlacementDomain().swapDimensions();
        r2.getPlacementDomain().swapDimensions();
        NonOverLap nb = new NonOverLap(rectangles, false, Dimension.Y, Dimension.X);
        nb.execute();
        assertEquals(0, rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMax());

        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(6,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(6,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMax());

    }

    @Test
    public void nonOverLapTopTest(){
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,6);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(6,6,6);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,0,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,9,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");
        Rectangle[] rectangles = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;

        r1.getPlacementDomain().swapDimensions();
        r2.getPlacementDomain().swapDimensions();
        NonOverLap nt = new NonOverLap(rectangles, true, Dimension.Y, Dimension.X);
        nt.execute();
        assertEquals(0, rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(0,rectangles[0].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(6,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(6,rectangles[0].getPlacementDomain().getPlacement(Dimension.Y).getMax());

        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMin());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.X).getMax());
        assertEquals(0,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMin());
        assertEquals(5,rectangles[1].getPlacementDomain().getPlacement(Dimension.Y).getMax());
    }



}
