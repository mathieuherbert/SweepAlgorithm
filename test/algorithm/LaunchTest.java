package algorithm;

import model.*;
import org.junit.Test;
import tree.Root;
import util.Print;

import java.util.HashMap;
import java.util.List;

/**
 * Created by math.herbert on 30/10/14.
 */
public class LaunchTest {

    @Test
    public void testExecute() throws Exception {
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
        Root root = new Root(rectangles,Dimension.X, Dimension.Y);
        Print.printPossibilites(root.getAllPossibilities());
    }

        @Test
    public void testThreeRectangleWithPb(){

            Rectangle[] rectangles = new Rectangle[3];
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
                rectangles[0] = r1;
            rectangles[1] = r2;
            rectangles[2] = r3;

            Root root = new Root(rectangles,Dimension.X,Dimension.Y);
            List<List<Possibility>> possibilities =  root.getAllPossibilities();
            Print.printPossibilites(possibilities);

    }
}
