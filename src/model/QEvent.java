package model;

/**
 * Created by math.herbert on 17/10/14.
 */
public class QEvent implements Comparable {

    private boolean isStart;

    private ForbiddenRegion forbiddenRegion;

    private Constraint constraint;

    private int minX;


    public QEvent(boolean isStart, ForbiddenRegion forbiddenRegion, Constraint constraint, int minX) {
        this.isStart = isStart;
        this.forbiddenRegion = forbiddenRegion;
        this.constraint = constraint;
        this.minX = minX;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean isStart) {
        this.isStart = isStart;
    }

    public ForbiddenRegion getForbiddenRegion() {
        return forbiddenRegion;
    }

    public void setForbiddenRegion(ForbiddenRegion forbiddenRegion) {
        this.forbiddenRegion = forbiddenRegion;
    }

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof QEvent)){
            return -1;
        }
        //return forbiddenRegion.compareTo(((QEvent) o).forbiddenRegion);
        if(getMinX() < ((QEvent) o).getMinX()){
            return -1;
        }else if (getMinX() > ((QEvent) o).getMinX()){
            return 1;
        }else {
            return 0;
        }
    }
}
