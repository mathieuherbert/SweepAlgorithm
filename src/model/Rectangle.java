package model;

import java.util.List;

/**
 * Created by math.herbert on 20/10/14.
 */
public class Rectangle {
   public static final int DEFAULT_WITNESS_VALUE = Integer.MAX_VALUE;
   private PlacementDomain placementDomain;
   private  int witness;
    private int finalExternal;
    private String name;
    public Rectangle(PlacementDomain placementDomain, String name) {
        this.placementDomain = placementDomain;
        this.witness = DEFAULT_WITNESS_VALUE;

        this.finalExternal = -1;
        this.name = name;
    }

    public Rectangle(Rectangle another){
        this.name = another.name;
        this.placementDomain = new PlacementDomain(another.placementDomain);
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

    public int getFinalExternal() {
        return finalExternal;
    }

    public void setFinalExternal(int finalExternal) {
        this.finalExternal = finalExternal;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "placementDomain=" + placementDomain +
                ", finalExternal=" + finalExternal +
                ", witness=" + witness +
                ", name='" + name + '\'' +
                '}';
    }
}
