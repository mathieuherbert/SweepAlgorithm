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

        Constraint c1 = new Constraint(domain, "c1");
        PlacementDomain p1 = new PlacementDomain(1,1,0,0,2,1);
        ForbiddenRegion f1 = new ForbiddenRegion();
        f1.computeForbiddenRegion(p1,4,4);
        c1.addForbiddenRegion(f1);
        constraints.add(c1);

        Constraint c2 = new Constraint(domain, "c2");
        PlacementDomain p2 = new PlacementDomain(2,2,2,2,1,4);
        ForbiddenRegion f2 = new ForbiddenRegion();
        f2.computeForbiddenRegion(p2,4,4);
        c2.addForbiddenRegion(f2);
        constraints.add(c2);


        Constraint c3 = new Constraint(domain, "c3");
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

    @Test
    public void testRectangleWithNOLL() throws Exception{

        PlacementDomain p1 = new PlacementDomain(0,5,0,4,4,4);
        Rectangle r1 = new Rectangle(p1);

        PlacementDomain p2 = new PlacementDomain(1,1,0,0,2,1);
        Rectangle r2 = new Rectangle(p2);

        PlacementDomain p3 = new PlacementDomain(2,2,2,2,1,4);
        Rectangle r3 = new Rectangle(p3);

        PlacementDomain p4 =  new PlacementDomain(3,3,0,0,3,2);
        Rectangle r4 = new Rectangle(p4);



        Rectangle rectangles[] = new Rectangle[4];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;


        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        System.out.println(nonOverLapLeft.algo());
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);


    }


    @Test
    public void testRectangleWithNOLLBis() throws Exception{

        PlacementDomain p1 = new PlacementDomain(0,5,2,2,4,4);
        Rectangle r1 = new Rectangle(p1);

        PlacementDomain p2 = new PlacementDomain(1,1,0,0,2,1);
        Rectangle r2 = new Rectangle(p2);

        PlacementDomain p3 = new PlacementDomain(2,2,2,2,1,4);
        Rectangle r3 = new Rectangle(p3);

        PlacementDomain p4 =  new PlacementDomain(3,3,0,0,3,2);
        Rectangle r4 = new Rectangle(p4);


        PlacementDomain p5 =  new PlacementDomain(4,8,2,3,2,2);
        Rectangle r5 = new Rectangle(p5);



        Rectangle rectangles[] = new Rectangle[5];

        rectangles[0] = r2;
        rectangles[1] = r3;
        rectangles[2] = r4;
        rectangles[3] = r5;
        rectangles[4] = r1;

        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        System.out.println(nonOverLapLeft.algo());
        System.out.println("r4 "+r1);
        System.out.println("r1 "+r2);
        System.out.println("r2 "+r3);
        System.out.println("r3 "+r4);
        System.out.println("r5 "+r5);


    }
}