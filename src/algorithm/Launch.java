package algorithm;

import model.Dimension;
import model.Rectangle;
import sun.launcher.resources.launcher;

/**
 * Created by math.herbert on 30/10/14.
 */
public class Launch {
    private Rectangle[] rectangles;

    private Dimension d1;

    private Dimension d2;

    public Launch(Rectangle[] rectangles, Dimension d1, Dimension d2) {
        this.rectangles = rectangles;
        this.d1 = d1;
        this.d2 = d2;
    }

    public void execute() throws Exception {
        int c = Integer.MAX_VALUE;

        int tmp = 0;
        //while there are modifications we use NonOverLap over the four bounds
        while(c != 0){
            c = 0;

            NonOverLap nonOverLap = new NonOverLap(rectangles,false,d1,d2);
            tmp = nonOverLap.execute();
            if(tmp == Integer.MAX_VALUE){
                throw new Exception("Impossible to place");
            }
            c += tmp;


//            System.out.println("NonOverLapRight");
            nonOverLap = new NonOverLap(rectangles,true,d1,d2);
            tmp = nonOverLap.execute();
            if(tmp == Integer.MAX_VALUE){
                throw new Exception("Impossible to place");
            }
            c += tmp;
            for(Rectangle rectangle : rectangles){
                rectangle.getPlacementDomain().swapDimensions();
            }
            nonOverLap = new NonOverLap(rectangles,false,d2,d1);
            tmp = nonOverLap.execute();
            if(tmp == Integer.MAX_VALUE){
                throw new Exception("Impossible to place");
            }
            c += tmp;
            nonOverLap = new NonOverLap(rectangles,true,d2,d1);
            tmp = nonOverLap.execute();
            if(tmp == Integer.MAX_VALUE){
                throw new Exception("Impossible to place");
            }
            c += tmp;
            for(Rectangle rectangle : rectangles){
                rectangle.getPlacementDomain().swapDimensions();
            }
        }
    }
    public Rectangle[] getRectangles() {
        return rectangles;
    }

    public void setRectangles(Rectangle[] rectangles) {
        this.rectangles = rectangles;
    }

    public Dimension getD1() {
        return d1;
    }

    public void setD1(Dimension d1) {
        this.d1 = d1;
    }

    public Dimension getD2() {
        return d2;
    }

    public void setD2(Dimension d2) {
        this.d2 = d2;
    }
}
