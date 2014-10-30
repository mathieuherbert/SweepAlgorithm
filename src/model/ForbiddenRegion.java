package model;

/**
 * Created by math.herbert on 13/10/14.
 */
public class ForbiddenRegion implements Comparable{
    private int minExternal;
    private int maxExternal;

    private int minInternal;
    private int maxInternal;

    public ForbiddenRegion(){

    }


    public void computeForbiddenRegion(PlacementDomain placementDomain, int width, int height) {

        int externalMin = placementDomain.getPlacement(placementDomain.getD1()).getMax() - width + 1;
        int externalMax = placementDomain.getPlacement(placementDomain.getD1()).getMin() + placementDomain.getPlacement(placementDomain.getD1()).getWidth() - 1;
        if (externalMin > externalMax) {
            return;
        }
        int internalMin = placementDomain.getPlacement(placementDomain.getD2()).getMax() - height + 1;
        int internalMax = placementDomain.getPlacement(placementDomain.getD2()).getMin() +
                placementDomain.getPlacement(placementDomain.getD2()).getWidth() - 1;
        if (internalMin > internalMax) {
            return;
        }

        setMinExternal(externalMin);
        setMaxExternal(externalMax);
        setMinInternal(internalMin);
        setMaxInternal(internalMax);

    }

    public boolean checkIfInForbiddenRegion(int external, int internal ){
        if(external >= minExternal && external <= maxExternal && internal >= minInternal && internal <= maxInternal){
            return true;
        }
        return false;

    }
    public int getMinExternal() {
        return minExternal;
    }
    public void setMinExternal(int minExternal) {
        this.minExternal = minExternal;
    }

    public void setMaxExternal(int maxExternal) {
        this.maxExternal = maxExternal;
    }

    public int getMaxExternal() {
        return maxExternal;
    }

    public int getMinInternal() {
        return minInternal;
    }

    public void setMinInternal(int minInternal) {
        this.minInternal = minInternal;
    }

    public int getMaxInternal() {
        return maxInternal;
    }

    public void setMaxInternal(int maxInternal) {
        this.maxInternal = maxInternal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForbiddenRegion that = (ForbiddenRegion) o;

        if (maxExternal != that.maxExternal) return false;
        if (maxInternal != that.maxInternal) return false;
        if (minExternal != that.minExternal) return false;
        if (minInternal != that.minInternal) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = minExternal;
        result = 31 * result + maxExternal;
        result = 31 * result + minInternal;
        result = 31 * result + maxInternal;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof ForbiddenRegion)){
            return -1;
        }
        if(minExternal < ((ForbiddenRegion) o).minExternal){
            return -1;
        }else if(minExternal > ((ForbiddenRegion) o).minExternal){
            return 1;
        }else {
            if(minInternal < ((ForbiddenRegion) o).minInternal){
                return -1;
            }else if(minInternal > ((ForbiddenRegion) o).minInternal){
                return 1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "ForbiddenRegion{" +
                "minExternal=" + minExternal +
                ", maxExternal=" + maxExternal +
                ", minInternal=" + minInternal +
                ", maxInternal=" + maxInternal +
                '}';
    }
}

