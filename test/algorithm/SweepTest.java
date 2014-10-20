package algorithm;

import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by math.herbert on 18/10/14.
 */
public class SweepTest {
    @Test
    public void testFindMinimum() throws Exception {
        Domain domain = new Domain(1,8,1,9);
        List<Constraint> constraints = new ArrayList<Constraint>();
        PlacementDomain placement = new PlacementDomain(1,8,1,8,5,4);

        Constraint c1 = new Constraint(domain);
        PlacementDomain p1 = new PlacementDomain(1,4,2,4,2,1);
        ForbiddenRegion f1 = new ForbiddenRegion();
        f1.computeForbiddenRegion(p1,5,4);
        c1.addForbiddenRegion(f1);
        constraints.add(c1);

        Constraint c2 = new Constraint(domain);
        PlacementDomain p2 = new PlacementDomain(4,4,6,6,3,1);
        ForbiddenRegion f2 = new ForbiddenRegion();
        f2.computeForbiddenRegion(p2,5,4);
        c2.addForbiddenRegion(f2);
        constraints.add(c2);


        Constraint c3 = new Constraint(domain);
        PlacementDomain p3 = new PlacementDomain(2,4,8,9,1,1);
        ForbiddenRegion f3 = new ForbiddenRegion();
        f3.computeForbiddenRegion(p3,5,4);
        c3.addForbiddenRegion(f3);
        constraints.add(c3);

        Constraint c4 = new Constraint(domain);
        PlacementDomain p4 = new PlacementDomain(7,7,1,1,1,3);
        ForbiddenRegion f4 = new ForbiddenRegion();
        f4.computeForbiddenRegion(p4,5,4);
        c4.addForbiddenRegion(f4);
        constraints.add(c4);

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();

        Point expectedPoint = new Point(3,8);
       // assertSame(expectedPoint, point);
        System.out.println(point);

    }

    @Test
    public void testHandleEvent() throws Exception {

    }

    @Test
    public void testAddForbiddenRegionToQEvent() throws Exception {

    }

    @Test
    public void testIsQEventsContainsEventForConstraint() throws Exception {

    }
}
