package model;

/**
 * Created by math.herbert on 13/10/14.
 */
public class ForbiddenRegion {
    private int minX;
    private int maxX;

    private int minY;
    private int maxY;

    public ForbiddenRegion(){

    }


    public void computeForbiddenRegion(PlacementDomain placementDomain, int width, int height) {
        PlacementDomain result = new PlacementDomain(width, height);
        int xMin = placementDomain.getMaxX() - width + 1;
        int xMax = placementDomain.getMinX() + placementDomain.getWidth() - 1;
        if (xMin > xMax) {
            return;
        }
        int yMin = placementDomain.getMaxY() - height + 1;
        int yMax = placementDomain.getMinY() + placementDomain.getHeight() - 1;
        if (yMin > yMax) {
            return;
        }

        setMinX(xMin);
        setMaxX(xMax);
        setMinY(yMin);
        setMaxY(yMax);

    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMinY() {
        return minY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForbiddenRegion that = (ForbiddenRegion) o;

        if (maxX != that.maxX) return false;
        if (maxY != that.maxY) return false;
        if (minX != that.minX) return false;
        if (minY != that.minY) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = minX;
        result = 31 * result + maxX;
        result = 31 * result + minY;
        result = 31 * result + maxY;
        return result;
    }
}

