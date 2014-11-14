package picture;

import model.Possibility;
import model.Rectangle;

/**
 * Created by Gutii on 08/11/14.
 */
public class ColoredPossibility {
    private Possibility possibility;


    private int rgb;

    public ColoredPossibility(Possibility possibility, int rgb) {
        this.possibility = possibility;
        this.rgb = rgb;
    }

    public Possibility getPossibility() {
        return possibility;
    }

    public void setPossibility(Possibility possibility) {
        this.possibility = possibility;
    }

    public int getRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
