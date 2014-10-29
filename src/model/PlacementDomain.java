package model;

/**
 * Created by math.herbert on 13/10/14.
 */
public class PlacementDomain {
    private int minExternal;
    private int maxExternal;

    private int minInternal;
    private int maxInternal;

    private int width;
    private int height;

    public PlacementDomain(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public PlacementDomain(int minExternal, int maxExternal, int minInternal, int maxInternal, int width, int height) {
        this.minExternal = minExternal;
        this.maxExternal = maxExternal;
        this.minInternal = minInternal;
        this.maxInternal = maxInternal;
        this.width = width;
        this.height = height;
    }

    public int getMinExternal() {
        return minExternal;
    }

    public void setMinExternal(int minExternal) {
        this.minExternal = minExternal;
    }

    public int getMaxExternal() {
        return maxExternal;
    }

    public void setMaxExternal(int maxExternal) {
        this.maxExternal = maxExternal;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
