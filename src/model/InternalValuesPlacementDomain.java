package model;

/**
 * Created by math.herbert on 29/10/14.
 */
public class InternalValuesPlacementDomain {

    private int min;

    private int max;

    private int width;

    public InternalValuesPlacementDomain(int min, int max, int width) {
        this.min = min;
        this.max = max;
        this.width = width;
    }

    @Override
    public String toString() {
        return "InternalValuesPlacementDomain{" +
                "min=" + min +
                ", max=" + max +
                ", width=" + width +
                '}';
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
