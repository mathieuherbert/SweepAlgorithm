package algorithm;

import model.Dimension;
import model.Rectangle;

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
    public void afficherRectangles(){
        for(int i = 0; i<rectangles.length; i++){
            System.out.println(rectangles[i].toString());
        }
    }
    public void execute(){
        int c = Integer.MAX_VALUE;
        afficherRectangles();
        while(c != 0){
            c = 0;
            System.out.println("NonOverLapLeft");
            System.out.println("d1 = " + d1);
            System.out.println("d2 = " + d2);

            NonOverLap nonOverLap = new NonOverLap(rectangles,false,d1,d2);
            c += nonOverLap.execute();
            System.out.println("c = " + c);
            afficherRectangles();
            System.out.println("NonOverLapRight");
            nonOverLap = new NonOverLap(rectangles,true,d1,d2);
            c += nonOverLap.execute();
            afficherRectangles();
            for(Rectangle rectangle : rectangles){
                rectangle.getPlacementDomain().swapDimensions();
            }
            System.out.println("NonOverLapBottom");
            nonOverLap = new NonOverLap(rectangles,false,d2,d1);
            c += nonOverLap.execute();
            afficherRectangles();
            System.out.println("NonOverLapTop");
            nonOverLap = new NonOverLap(rectangles,true,d2,d1);
            c += nonOverLap.execute();
            afficherRectangles();
            for(Rectangle rectangle : rectangles){
                rectangle.getPlacementDomain().swapDimensions();
            }
            System.out.println("finalc = " + c);
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
