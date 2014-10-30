package algorithm;

import model.Dimension;
import model.InternalValuesPlacementDomain;
import model.PlacementDomain;
import model.Rectangle;
import org.junit.Test;
import tree.Root;

import java.util.HashMap;

/**
 * Created by math.herbert on 30/10/14.
 */
public class TestNonOverLapSpecific {

    @Test
    public void testExecute() throws Exception {
        InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(0,0,3);
        InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(0,0,4);
        HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h1.put(Dimension.X, ivp11);
        h1.put(Dimension.Y, ivp12);
        PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(0,2,1);
        InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(0,6,1);
        HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
        h2.put(Dimension.X, ivp21);
        h2.put(Dimension.Y, ivp22);
        PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        Rectangle rectangles[] = new Rectangle[2];
        rectangles[0] = r1;
        rectangles[1] = r2;
//        for(int i = 0; i<rectangles.length;i++){
//            rectangles[i].getPlacementDomain().swapDimensions();
//        }
        //NonOverLap nonOverLap = new NonOverLap(rectangles,false, Dimension.Y, Dimension.X);
        Root root = new Root(rectangles,Dimension.X,Dimension.Y);
        System.out.println(root.getAllPossibilities());
        System.out.println(r1);
        System.out.println(r2);
    }


}
