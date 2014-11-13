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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getD1Width() {
        return d1Width;
    }

    public void setD1Width(int d1Width) {
        this.d1Width = d1Width;
    }

    public int getD2Width() {
        return d2Width;
    }

    public void setD2Width(int d2Width) {
        this.d2Width = d2Width;
    }

    public Possibility(String name, Dimension d1, int d1Value, int d1Width, Dimension d2, int d2Value, int d2Width) {
        this.name = name;
        this.d1 = d1;
        this.d1Value = d1Value;
        this.d1Width = d1Width;
        this.d2 = d2;
        this.d2Value = d2Value;
        this.d2Width = d2Width;
    }
    public Possibility(Possibility other){
        this.name = other.name;
        this.d1 = other.d1;
        this.d1Value = other.d1Value;
        this.d1Width = other.d1Width;
        this.d2 = other.d2;
        this.d2Value = other.d2Value;
        this.d2Width = other.d2Width;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Possibility that = (Possibility) o;

        if (d1Value != that.d1Value) return false;
        if (d1Width != that.d1Width) return false;
        if (d2Value != that.d2Value) return false;
        if (d2Width != that.d2Width) return false;
        if (d1 != that.d1) return false;
        if (d2 != that.d2) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (d1 != null ? d1.hashCode() : 0);
        result = 31 * result + d1Value;
        result = 31 * result + d1Width;
        result = 31 * result + (d2 != null ? d2.hashCode() : 0);
        result = 31 * result + d2Value;
        result = 31 * result + d2Width;
        return result;
    }
}
