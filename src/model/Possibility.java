package model;

/**
 * Created by math.herbert on 11/11/14.
 */
public class Possibility {
    String name;

    Dimension d1;

    int d1Value;

    int d1Width;

    Dimension d2;

    int d2Value;

    int d2Width;

    public Possibility(String name, Dimension d1, int d1Value, int d1Width, Dimension d2, int d2Value, int d2Width) {
        this.name = name;
        this.d1 = d1;
        this.d1Value = d1Value;
        this.d1Width = d1Width;
        this.d2 = d2;
        this.d2Value = d2Value;
        this.d2Width = d2Width;
    }

    public Dimension getD1() {
        return d1;
    }

    public void setD1(Dimension d1) {
        this.d1 = d1;
    }

    public int getD1Value() {
        return d1Value;
    }

    public void setD1Value(int d1Value) {
        this.d1Value = d1Value;
    }

    public Dimension getD2() {
        return d2;
    }

    public void setD2(Dimension d2) {
        this.d2 = d2;
    }

    public int getD2Value() {
        return d2Value;
    }

    public void setD2Value(int d2Value) {
        this.d2Value = d2Value;
    }

    @Override
    public String toString() {
        return "Possibility{" +
                "name='" + name + '\'' +
                ", d1=" + d1 +
                ", d1Value=" + d1Value +
                ", d1Width=" + d1Width +
                ", d2=" + d2 +
                ", d2Value=" + d2Value +
                ", d2Width=" + d2Width +
                '}';
    }
}
