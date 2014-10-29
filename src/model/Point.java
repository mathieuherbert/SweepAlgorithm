package model;

/**
 * Created by math.herbert on 17/10/14.
 */
public class Point {

    private int external;

    private int internal;

    private boolean r;

    public Point(int external, int internal, boolean r) {
        this.external = external;
        this.internal = internal;
        this.r = r;
    }

    public int getExternal() {
        return external;
    }

    public void setExternal(int external) {
        this.external = external;
    }

    public int getInternal() {
        return internal;
    }

    public void setInternal(int internal) {
        this.internal = internal;
    }

    public boolean isR() {
        return r;
    }

    public void setR(boolean r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (external != point.external) return false;
        if (internal != point.internal) return false;
        if (r != point.r) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = external;
        result = 31 * result + internal;
        result = 31 * result + (r ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "external=" + external +
                ", internal=" + internal +
                ", r=" + r +
                '}';
    }
}
