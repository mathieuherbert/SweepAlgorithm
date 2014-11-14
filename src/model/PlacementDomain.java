package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * PlacementDomain is composed of Dimension and InternalValuesPlacementDomain
 */
public class PlacementDomain {

    private HashMap<Dimension, InternalValuesPlacementDomain> placements;
    private Dimension d1;
    private Dimension d2;


    public PlacementDomain(HashMap<Dimension, InternalValuesPlacementDomain> placements, Dimension d1, Dimension d2) {

        this.placements = placements;
        this.d1 = d1;
        this.d2 = d2;
    }

    /**
     * Clone another
     * @param another
     */
    public PlacementDomain(PlacementDomain another){
        this.d1 = another.d1;
        this.d2 = another.d2;
        this.placements = new HashMap<Dimension, InternalValuesPlacementDomain>();
        Iterator iterator = another.placements.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Dimension,InternalValuesPlacementDomain> mapEntry = (Map.Entry) iterator.next();
            this.placements.put(mapEntry.getKey(),new InternalValuesPlacementDomain(mapEntry.getValue()));
        }
    }
    public InternalValuesPlacementDomain getPlacement(Dimension dimension){
        return placements.get(dimension);
    }

    /**
     * Swamp d1 and d2
     */
    public  void swapDimensions(){
        Dimension tmp = d1;
        d1 = d2;
        d2 = tmp;
    }

    public Dimension getD1() {
        return d1;
    }

    public void setD1(Dimension d1) {
        this.d1 = d1;
    }

    public Dimension getD2() {
        return d2;
    }

    public void setD2(Dimension d2) {
        this.d2 = d2;
    }

    @Override
    public String toString() {
        return "PlacementDomain{" +
                "placements=" + placements +
                ", d1=" + d1 +
                ", d2=" + d2 +
                '}';
    }
}
