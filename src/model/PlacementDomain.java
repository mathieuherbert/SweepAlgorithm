package model;

/**
 * Created by math.herbert on 13/10/14.
 */
public class PlacementDomain {
    private int minX;
    private int maxX;

    private int minY;
    private int maxY;

    private int width;
    private int height;


    public PlacementDomain(int width, int height){
        this.minX =  0;
        this.maxX =  0;
        this.minY =  0;
        this.maxY =  0;

        this.width = width;
        this.height = height;


    }

    public PlacementDomain(int minX, int maxX, int minY, int maxY, int width, int height){
        this.minX =  minX;
        this.maxX =  maxX;
        this.minY =  minY;
        this.maxY =  maxY;

        this.width = width;
        this.height = height;


    }
    public void setHeight(int height) {
        this.height = height;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "PlacementDomain{" +
                "minX=" + minX +
                ", maxX=" + maxX +
                ", minY=" + minY +
                ", maxY=" + maxY +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
