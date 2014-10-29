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
        PlacementDomain p1 = new PlacementDomain(1,4,2,4,2,1);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        PlacementDomain p2 = new PlacementDomain(4,4,6,6,3,1);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        PlacementDomain p3 = new PlacementDomain(2,4,8,9,1,1);
        Rectangle r3 = new Rectangle(p3, "Rectangle 3");

        PlacementDomain p4 = new PlacementDomain(7,7,1,1,1,3);
        Rectangle r4 = new Rectangle(p4, "Rectangle 4");

        PlacementDomain p5 = new PlacementDomain(1,8,1,8,5,4);
        Rectangle r5 = new Rectangle(p5, "Rectangle 5");

        Rectangle rectangles[] = new Rectangle[5];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;
        rectangles[4] = r5;

        NonOverLap nonOverLap = new NonOverLap(rectangles,true, Dimension.X, Dimension.Y);
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
            HashMap<Dimension,InternalValuesDomain> h1 = new HashMap<Dimension,InternalValuesDomain>();
            h1.put(Dimension.X, i1);
            h1.put(Dimension.Y, i2);
        Domain domain = new Domain(h1);
        List<Constraint> constraints = new ArrayList<Constraint>();
        PlacementDomain placement = new PlacementDomain(1,8,1,8,5,4);

        Constraint c1 = new Constraint(domain, "c1");
        PlacementDomain p1 = new PlacementDomain(1,4,2,4,2,1);
        ForbiddenRegion f1 = new ForbiddenRegion();
        f1.computeForbiddenRegion(p1,5,4);
        c1.addForbiddenRegion(f1);
        constraints.add(c1);

        Constraint c2 = new Constraint(domain, "c2");
        PlacementDomain p2 = new PlacementDomain(4,4,6,6,3,1);
        ForbiddenRegion f2 = new ForbiddenRegion();
        f2.computeForbiddenRegion(p2,5,4);
        c2.addForbiddenRegion(f2);
        constraints.add(c2);


        Constraint c3 = new Constraint(domain,  "c3");
        PlacementDomain p3 = new PlacementDomain(2,4,8,9,1,1);
        ForbiddenRegion f3 = new ForbiddenRegion();
        f3.computeForbiddenRegion(p3,5,4);
        c3.addForbiddenRegion(f3);
        constraints.add(c3);

        Constraint c4 = new Constraint(domain,  "c4");
        PlacementDomain p4 = new PlacementDomain(7,7,1,1,1,3);
        ForbiddenRegion f4 = new ForbiddenRegion();
        f4.computeForbiddenRegion(p4,5,4);
        c4.addForbiddenRegion(f4);
        constraints.add(c4);

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure,Dimension.Y, Dimension.X, false);
        Point point = sweep.find();

        Point expectedPoint = new Point(3,8, true);
       // assertSame(expectedPoint, point);
        System.out.println(point);

    }

}
