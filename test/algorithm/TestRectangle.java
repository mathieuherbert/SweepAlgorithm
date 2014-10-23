package algorithm;

import model.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by Gutii on 20/10/14.
 */
public class TestRectangle {
    @Rule
    public ErrorCollector collector = new ErrorCollector();
    @Test
    public void testZeroRectangle(){
        Rectangle[] rectangles = new Rectangle[0];
        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        nonOverLapLeft.algo();
        assertSame(0, nonOverLapLeft.getRectangles().length);

    }

    @Test
    public void testOneRectangleZeroZero(){
        Rectangle[] rectangles = new Rectangle[1];
        PlacementDomain p1 = new PlacementDomain(0,0,0,0,4,4);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        rectangles[0] = r1;

        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        nonOverLapLeft.algo();
        Rectangle[] rectangles1 = nonOverLapLeft.getRectangles();
        assertSame(1, rectangles1.length);

        assertSame(0, rectangles1[0].getFinalX());
        assertSame(0, rectangles1[0].getWitness());
    }

    @Test
    public void testOneRectangleZeroMinusOne(){
        Rectangle[] rectangles = new Rectangle[1];
        PlacementDomain p1 = new PlacementDomain(0,0,-1,-1,4,4);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        rectangles[0] = r1;

        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        nonOverLapLeft.algo();
        Rectangle[] rectangles1 = nonOverLapLeft.getRectangles();
        assertSame(1, rectangles1.length);

        assertSame(0, rectangles1[0].getFinalX());
        assertSame(-1, rectangles1[0].getWitness());
    }

    @Test
    public void testOneRectangleMinusOneZero(){
        Rectangle[] rectangles = new Rectangle[1];
        PlacementDomain p1 = new PlacementDomain(-1,-1,0,0,4,4);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        rectangles[0] = r1;

        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        nonOverLapLeft.algo();
        Rectangle[] rectangles1 = nonOverLapLeft.getRectangles();
        assertSame(1, rectangles1.length);

        assertSame(-1, rectangles1[0].getFinalX());
        assertSame(0, rectangles1[0].getWitness());
    }

    @Test
    public void testOneRectangleZeroWitness(){
        int maxY = 3;
        int[] result = new int[maxY+1];
        for(int i = 0; i< 1000; i++){
            Rectangle[] rectangles = new Rectangle[1];
            PlacementDomain p1 = new PlacementDomain(0,0,0,maxY,4,4);
            Rectangle r1 = new Rectangle(p1, "Rectangle 1");

            rectangles[0] = r1;

            NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
            nonOverLapLeft.algo();
            Rectangle[] rectangles1 = nonOverLapLeft.getRectangles();
            assertSame(1, rectangles1.length);

            assertSame(0, rectangles1[0].getFinalX());

            result[rectangles1[0].getWitness()] ++;
        }
        for(int i=0; i<maxY+1; i++){
            assertNotSame(0, result[i]);
        }
    }



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
        assertSame(3,point.getX());
        assertTrue(3 == point.getY() || 2 == point.getY() );
    }

    @Test
    public void testRectangleWithNOLL() throws Exception{
        for(int i =0; i<100; i++){
        PlacementDomain p1 = new PlacementDomain(0,5,0,4,4,4);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        PlacementDomain p2 = new PlacementDomain(1,1,0,0,2,1);
        Rectangle r2 = new Rectangle(p2, "Rectangle 2");

        PlacementDomain p3 = new PlacementDomain(2,2,2,2,1,4);
        Rectangle r3 = new Rectangle(p3, "Rectangle 3");

        PlacementDomain p4 =  new PlacementDomain(3,3,0,0,3,2);
        Rectangle r4 = new Rectangle(p4, "Rectangle 4");



        Rectangle rectangles[] = new Rectangle[4];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;


        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        System.out.println(nonOverLapLeft.algo());
        assertSame(3, r1.getFinalX());
        // System.out.println(r1.getWitness());
        assertTrue(3 == r1.getWitness() || 4 == r1.getWitness() || 2 == r1.getWitness());

        assertSame(1,r2.getFinalX());
        assertSame(0,r2.getWitness());

        assertSame(2,r3.getFinalX());
        assertSame(2,r3.getWitness());

        assertSame(3,r4.getFinalX());
        assertSame(0,r4.getWitness());
      //  System.out.println(r1);
       // System.out.println(r2);
        //System.out.println(r3);
        //System.out.println(r4);
        }

    }


    @Test
    public void testRectangleWithNOLLBis() throws Exception{
        for(int j = 0; j<100; j++){
        PlacementDomain p1 = new PlacementDomain(0,5,2,2,4,4);
        Rectangle r1 = new Rectangle(p1, "Rectangle 1");

        PlacementDomain p2 = new PlacementDomain(1,1,0,0,2,1);
        Rectangle r2 = new Rectangle(p2,"Rectangle 2");

        PlacementDomain p3 = new PlacementDomain(2,2,2,2,1,4);
        Rectangle r3 = new Rectangle(p3, "Rectangle 3");

        PlacementDomain p4 =  new PlacementDomain(3,3,0,0,3,2);
        Rectangle r4 = new Rectangle(p4, "Rectangle 4");


        PlacementDomain p5 =  new PlacementDomain(4,8,2,3,2,2);
        Rectangle r5 = new Rectangle(p5, "Rectangle 5");

        PlacementDomain p6 =  new PlacementDomain(0,8,2,5,3,2);
        Rectangle r6 = new Rectangle(p6, "Rectangle 6");




        Rectangle rectangles[] = new Rectangle[6];

        rectangles[0] = r6;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;
        rectangles[4] = r5;
        rectangles[5] = r1;

        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        assertSame(0,nonOverLapLeft.algo());
        assertSame(1, r2.getFinalX());
        assertSame(0, r2.getWitness());

        assertSame(2, r3.getFinalX());
        assertSame(2, r3.getWitness());

        assertSame(3, r4.getFinalX());
        assertSame(0, r4.getWitness());

        assertSame(7, r5.getFinalX());
        System.out.println("r5 : "+r5.getWitness());
            System.out.println("r6 : "+r6.getWitness());
            collector.checkThat(true, equalTo((r5.getWitness() == 2 && (4 == r6.getWitness() || 5 == r6.getWitness())) || (r5.getWitness() == 3 && 5 == r6.getWitness())));

        assertSame(7, r6.getFinalX());
        assertTrue(5 == r6.getWitness() || 4 == r6.getWitness());

        assertSame(3, r1.getFinalX());
        assertSame(2, r1.getWitness());
        System.out.println("r1 "+r2);
        System.out.println("r2 "+r3);
        System.out.println("r3 "+r4);
        System.out.println("r4 "+r1);
        System.out.println("r5 "+r5);
        System.out.println("r6 "+r6);
        }
    }
}