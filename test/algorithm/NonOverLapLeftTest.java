package algorithm;

import model.Domain;
import model.PlacementDomain;
import model.Rectangle;
import org.junit.Test;

/**
 * Created by math.herbert on 20/10/14.
 */
public class NonOverLapLeftTest {
    @Test
    public void testExecute() throws Exception {
        PlacementDomain p1 = new PlacementDomain(2,4,2,4,2,1);
        Rectangle r1 = new Rectangle(p1);

        PlacementDomain p2 = new PlacementDomain(4,4,6,6,3,1);
        Rectangle r2 = new Rectangle(p2);

        PlacementDomain p3 = new PlacementDomain(2,4,8,9,1,1);
        Rectangle r3 = new Rectangle(p3);

        PlacementDomain p4 = new PlacementDomain(7,7,1,1,1,3);
        Rectangle r4 = new Rectangle(p4);

        PlacementDomain p5 = new PlacementDomain(1,8,1,8,5,4);
        Rectangle r5 = new Rectangle(p5);

        Rectangle rectangles[] = new Rectangle[5];
        rectangles[0] = r1;
        rectangles[1] = r2;
        rectangles[2] = r3;
        rectangles[3] = r4;
        rectangles[4] = r5;

        NonOverLapLeft nonOverLapLeft = new NonOverLapLeft(rectangles);
        System.out.println(nonOverLapLeft.algo());
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);


    }
}
