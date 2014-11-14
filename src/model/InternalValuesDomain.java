package model;

/**
 * Internal Values for a Domain with a min and a max values
 */
public class InternalValuesDomain {
    private int min;
    private int max;
    public InternalValuesDomain(int min, int max){
        this.min = min;
        this.max = max;
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
}