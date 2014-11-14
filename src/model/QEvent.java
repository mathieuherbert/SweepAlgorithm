package model;

/**
 * An Event for the Queue Event in the Sweep Algorithm
 */
public class QEvent implements Comparable {

    private boolean isStart;

    private ForbiddenRegion forbiddenRegion;

    private Constraint constraint;

    private int value;


    /**
     *
     * @param isStart if the event is a start event
     * @param forbiddenRegion the forbidden region related to the event
     * @param constraint the constraint related to the event
     * @param value the value where the event is triggered
     */
    public QEvent(boolean isStart, ForbiddenRegion forbiddenRegion, Constraint constraint, int value) {
        this.isStart = isStart;
        this.forbiddenRegion = forbiddenRegion;
        this.constraint = constraint;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @param o another
     * @return value > 0.value
     */
    @Override
    public int compareTo(Object o) {
        if(! (o instanceof QEvent)){
            return -1;
        }
        //return forbiddenRegion.compareTo(((QEvent) o).forbiddenRegion);
        if(getValue() < ((QEvent) o).getValue()){
            return -1;
        }else if (getValue() > ((QEvent) o).getValue()){
            return 1;
        }else {
            return 0;
        }
    }
}
