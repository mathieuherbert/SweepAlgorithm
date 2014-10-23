package algorithm;

import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by math.herbert on 18/10/14.
 */
public class SweepTest {
    @Test
    public void testFindMinimum() throws Exception {
        Domain domain = new Domain(1,8,1,8);
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
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();

        Point expectedPoint = new Point(3,8, true);
       // assertSame(expectedPoint, point);
        System.out.println(point);

    }

    @Test
    public void testZeroZero(){
        Domain domain = new Domain(0,0,0,0);
        List<Constraint> constraints = new ArrayList<Constraint>();

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();
        assertSame(0, point.getX());
        assertSame(0, point.getY());
        assertTrue(point.isR());
    }

    @Test
    public void testMinusOneZero(){
        Domain domain = new Domain(-1,-1,0,0);
        List<Constraint> constraints = new ArrayList<Constraint>();

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();
        assertSame(-1, point.getX());
        assertSame(0, point.getY());
        assertTrue(point.isR());
    }

    @Test
    public void testZeroMinusOne(){
        Domain domain = new Domain(0,0,-1,-1);
        List<Constraint> constraints = new ArrayList<Constraint>();

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();
        assertSame(0, point.getX());
        assertSame(-1, point.getY());
        assertTrue(point.isR());
    }

    @Test
    public void testZeroY(){
        int maxY = 5;
        int[] result = new int[maxY+1];
        Domain domain = new Domain(0,0,0, maxY);

        List<Constraint> constraints = new ArrayList<Constraint>();

        DataStructure structure = new DataStructure(constraints,domain);
        for(int i = 0; i<1000; i++){
            Sweep sweep = new Sweep(structure);
            Point point = sweep.findMinimum();
            assertSame(0, point.getX());
           // assertSame(-1, point.getY());
            result[point.getY()]++;
            assertTrue(point.isR());
        }
        for(int i =0; i< maxY+1; i++){
            assertNotSame(0, result[i]);
        }
    }

    @Test
    public void testImpossibleToPlace(){
        Domain domain = new Domain(0,0,0,0);
        List<Constraint> constraints = new ArrayList<Constraint>();

        Constraint c1 = new Constraint(domain, "c1");
        PlacementDomain p1 = new PlacementDomain(0,0,1,1,2,1);
        ForbiddenRegion f1 = new ForbiddenRegion();
        f1.computeForbiddenRegion(p1,5,4);
        c1.addForbiddenRegion(f1);
        constraints.add(c1);

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();
        assertSame(0, point.getX());
        assertSame(0, point.getY());
        assertFalse(point.isR());
    }


}
