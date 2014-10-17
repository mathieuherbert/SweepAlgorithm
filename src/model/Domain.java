package model;

/**
 * Created by math.herbert on 17/10/14.
 */
public class Domain {
    private int minX;

    private int maxX;

    private int minY;

    private int maxY;

    public Domain(int minX, int maxX, int minY, int maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    private int getMinX(){
        return minX;
    }

    private int getMaxX(){
        return  this.maxX;
    }

    private int getMinY(){
        return this.minY;
    }

    private int getMaxY(){
        return this.maxY;
    }
}
