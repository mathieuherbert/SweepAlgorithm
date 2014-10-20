package model;

import java.util.List;

/**
 * Created by math.herbert on 20/10/14.
 */
public class Rectangle {
   public static final int DEFAULT_WITNESS_VALUE = Integer.MAX_VALUE;
   private PlacementDomain placementDomain;
   private  int witness;
    private int finalX;
    public Rectangle(PlacementDomain placementDomain) {
        this.placementDomain = placementDomain;
        this.witness = DEFAULT_WITNESS_VALUE;
        this.finalX = placementDomain.getMinX();
    }

    public PlacementDomain getPlacementDomain() {
        return placementDomain;
    }

    public void setPlacementDomain(PlacementDomain placementDomain) {
        this.placementDomain = placementDomain;
    }

    public int getWitness() {
        return witness;
    }

    public void setWitness(int witness) {
        this.witness = witness;
    }

    public int getFinalX() {
        return finalX;
    }

    public void setFinalX(int finalX) {
        this.finalX = finalX;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "placementDomain=" + placementDomain +
                ", witness=" + witness +
                ", finalX=" + finalX +
                '}';
    }
}
