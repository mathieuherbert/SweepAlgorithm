package algorithm;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by math.herbert on 17/10/14.
 */
public class Sweep {

    List<QEvent> qEvents;

    DataStructure structure;

    public Sweep(DataStructure structure){
        this.structure = structure;
        qEvents = new ArrayList<QEvent>();
    }

    public Point findMinimum() throws Exception {
        Iterator<Constraint> itConstraints = structure.getConstraints().iterator();

        //for each constraint add forbidden regions to a qevent
        while(itConstraints.hasNext()){
            Constraint cons = itConstraints.next();
            cons.orderForbiddenRegion();
            Iterator<ForbiddenRegion> forbiddenRegionIterator  = cons.getForbiddenRegions().iterator();
            while(forbiddenRegionIterator.hasNext()){
                ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
                int minValue = Math.max(structure.getDomain().getMinX(), forbiddenRegion.getMinX()) ;
                QEvent event = new QEvent(true, forbiddenRegion,cons, minValue);
                qEvents.add(event);
                if(forbiddenRegion.getMaxX()+1<= structure.getDomain().getMaxX()){
                    QEvent eventEnd = new QEvent(false, forbiddenRegion,cons, forbiddenRegion.getMaxX()+1);
                    qEvents.add(event);
                }
            }

        }
        Collections.sort(qEvents);
        //if qevent is empty or the first x is free
        if(qEvents.size() == 0 || qEvents.get(0).getMinX() > structure.getDomain().getMinX() ){
            return new Point(structure.getDomain().getMinX(), (int) (Math.random()*(structure.getDomain().getMaxY() - structure.getDomain().getMinY())) + structure.getDomain().getMinY());
        } else {
            int[] pStatus = new int[structure.getDomain().getMaxY() - structure.getDomain().getMinY()];
            for(int i= 0; i < pStatus.length; i++){
                pStatus[i] = 0;
            }
            //TODO manage 1 to PStatus
            while (qEvents.size() != 0){
                int delta = qEvents.get(0).getMinX();
                while(qEvents.size() > 0 && qEvents.get(0).getMinX() == delta){
                    handleEvent(qEvents.get(0));
                }
                List<Integer> possibleValues = new ArrayList<Integer>();
                for(int i =0; i< pStatus.length; i++){
                    if(pStatus[i] == 0){
                        possibleValues.add(i);
                    }
                }
                if(possibleValues.size() > 0){
                    int y = possibleValues.get((int)(Math.random()*possibleValues.size()))+structure.getDomain().getMinY();
                    return  new Point(delta, y);
                }
            }
        }
        throw new Exception("no point was found");
    }

    public void handleEvent(QEvent qEvent){

    }
}
