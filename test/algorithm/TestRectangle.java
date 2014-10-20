package algorithm;

import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gutii on 20/10/14.
 */
public class TestRectangle {

    @Test
    public void testRectangle() throws Exception{
        Domain domain = new Domain(0,3,0,3);
        List<Constraint> constraints = new ArrayList<Constraint>();
        PlacementDomain placement = new PlacementDomain(0,5,0,7,4,4);

        Constraint c1 = new Constraint(domain);
        PlacementDomain p1 = new PlacementDomain(1,1,0,0,2,1);
        ForbiddenRegion f1 = new ForbiddenRegion();
        f1.computeForbiddenRegion(p1,4,4);
        c1.addForbiddenRegion(f1);
        constraints.add(c1);

        Constraint c2 = new Constraint(domain);
        PlacementDomain p2 = new PlacementDomain(2,2,2,2,1,4);
        ForbiddenRegion f2 = new ForbiddenRegion();
        f2.computeForbiddenRegion(p2,4,4);
        c2.addForbiddenRegion(f2);
        constraints.add(c2);


        Constraint c3 = new Constraint(domain);
        PlacementDomain p3 = new PlacementDomain(3,3,0,0,3,2);
        ForbiddenRegion f3 = new ForbiddenRegion();
        f3.computeForbiddenRegion(p3,4,4);
        c3.addForbiddenRegion(f3);
        constraints.add(c3);

        DataStructure structure = new DataStructure(constraints,domain);
        Sweep sweep = new Sweep(structure);
        Point point = sweep.findMinimum();
        System.out.println(point);
    }
}