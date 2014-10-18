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
    public int getMinX(){
        return minX;
    }

    public int getMaxX(){
        return  this.maxX;
    }

    public int getMinY(){
        return this.minY;
    }

    public int getMaxY(){
        return this.maxY;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Domain domain = (Domain) o;

        if (maxX != domain.maxX) return false;
        if (maxY != domain.maxY) return false;
        if (minX != domain.minX) return false;
        if (minY != domain.minY) return false;

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
