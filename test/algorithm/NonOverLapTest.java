package algorithm;

import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by math.herbert on 29/10/14.
 */
public class NonOverLapTest {

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

        InternalValuesPlacementDomain ivp51 = new InternalValuesPlacementDomain(1,8,5);
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
        for(int i = 0; i<rectangles.length;i++){
            rectangles[i].getPlacementDomain().swapDimensions();
        }
        NonOverLap nonOverLap = new NonOverLap(rectangles,false, Dimension.Y, Dimension.X);
        System.out.println(nonOverLap.algo());
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
    }

        @Test
    public void testFind() throws Exception {
            InternalValuesDomain i1 = new InternalValuesDomain(1,8);
            InternalValuesDomain i2 = new InternalValuesDomain(1,8);
            HashMap<Dimension,InternalValuesDomain> d1 = new HashMap<Dimension,InternalValuesDomain>();
            d1.put(Dimension.X, i1);
            d1.put(Dimension.Y, i2);
        Domain domain = new Domain(d1);
        List<Constraint> constraints = new ArrayList<Constraint>();
            InternalValuesPlacementDomain ivp51 = new InternalValuesPlacementDomain(1,8,5);
            InternalValuesPlacementDomain ivp52 = new InternalValuesPlacementDomain(1,8,4);
            HashMap<Dimension, InternalValuesPlacementDomain> h5 = new HashMap<Dimension, InternalValuesPlacementDomain>();
            h5.put(Dimension.X, ivp51);
            h5.put(Dimension.Y, ivp52);
            PlacementDomain placement = new PlacementDomain(h5, Dimension.X, Dimension.Y);


        Constraint c1 = new Constraint(domain, "c1");
            InternalValuesPlacementDomain ivp11 = new InternalValuesPlacementDomain(1,4,2);
            InternalValuesPlacementDomain ivp12 = new InternalValuesPlacementDomain(2,4,1);
            HashMap<Dimension, InternalValuesPlacementDomain> h1 = new HashMap<Dimension, InternalValuesPlacementDomain>();
            h1.put(Dimension.X, ivp11);
            h1.put(Dimension.Y, ivp12);
            PlacementDomain p1 = new PlacementDomain(h1,Dimension.X,Dimension.Y );

        ForbiddenRegion f1 = new ForbiddenRegion();
        f1.computeForbiddenRegion(p1,5,4);
        c1.addForbiddenRegion(f1);
        constraints.add(c1);

        Constraint c2 = new Constraint(domain, "c2");
            InternalValuesPlacementDomain ivp21 = new InternalValuesPlacementDomain(4,4,3);
            InternalValuesPlacementDomain ivp22 = new InternalValuesPlacementDomain(6,6,1);
            HashMap<Dimension, InternalValuesPlacementDomain> h2 = new HashMap<Dimension, InternalValuesPlacementDomain>();
            h2.put(Dimension.X, ivp21);
            h2.put(Dimension.Y, ivp22);
            PlacementDomain p2 = new PlacementDomain(h2, Dimension.X, Dimension.Y);
        ForbiddenRegion f2 = new ForbiddenRegion();
        f2.computeForbiddenRegion(p2,5,4);
        c2.addForbiddenRegion(f2);
        constraints.add(c2);


        Constraint c3 = new Constraint(domain,  "c3");
            InternalValuesPlacementDomain ivp31 = new InternalValuesPlacementDomain(2,4,1);
            InternalValuesPlacementDomain ivp32 = new InternalValuesPlacementDomain(8,9,1);
            HashMap<Dimension, InternalValuesPlacementDomain> h3 = new HashMap<Dimension, InternalValuesPlacementDomain>();
            h3.put(Dimension.X, ivp31);
            h3.put(Dimension.Y, ivp32);
            PlacementDomain p3 = new PlacementDomain(h3, Dimension.X, Dimension.Y);
        ForbiddenRegion f3 = new ForbiddenRegion();
        f3.computeForbiddenRegion(p3,5,4);
        c3.addForbiddenRegion(f3);
        constraints.add(c3);

        Constraint c4 = new Constraint(domain,  "c4");
            InternalValuesPlacementDomain ivp41 = new InternalValuesPlacementDomain(7,7,1);
            InternalValuesPlacementDomain ivp42 = new InternalValuesPlacementDomain(1,1,3);
            HashMap<Dimension, InternalValuesPlacementDomain> h4 = new HashMap<Dimension, InternalValuesPlacementDomain>();
            h4.put(Dimension.X, ivp41);
            h4.put(Dimension.Y, ivp42);
            PlacementDomain p4 = new PlacementDomain(h4, Dimension.X, Dimension.Y);
        ForbiddenRegion f4 = new ForbiddenRegion();
        f4.computeForbiddenRegion(p4,5,4);
        c4.addForbiddenRegion(f4);
        constraints.add(c4);

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure,Dimension.X, Dimension.Y, false);
        Point point = sweep.find();

        Point expectedPoint = new Point(3,8, true);
       // assertSame(expectedPoint, point);
        System.out.println(point);

    }

}
