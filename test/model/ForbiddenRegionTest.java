package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by math.herbert on 13/10/14.
 */
public class ForbiddenRegionTest {
    @Test
    public void testComputeForbiddenRegion() throws Exception {
        PlacementDomain placement = new PlacementDomain(4,7,7,8,3,2);
        ForbiddenRegion forbiddenRegion = new ForbiddenRegion();

        forbiddenRegion.computeForbiddenRegion(placement,3,5);


        ForbiddenRegion forbiddenRegionExpected = new ForbiddenRegion();
        forbiddenRegionExpected.setMinX(5);
        forbiddenRegionExpected.setMaxX(6);
        forbiddenRegionExpected.setMinY(4);
        forbiddenRegionExpected.setMaxY(8);
        assertEquals(forbiddenRegionExpected, forbiddenRegion);


    }
}
