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

    int nbZeroInPStatus;

    public Sweep(DataStructure structure){
        this.structure = structure;
        qEvents = new ArrayList<QEvent>();
        nbZeroInPStatus = 0;
    }

    public Point findMinimum() throws Exception {

        Iterator<Constraint> itConstraints = structure.getConstraints().iterator();

        //for each constraint add forbidden regions to a qevent
        while(itConstraints.hasNext()){
            Constraint cons = itConstraints.next();
            cons.orderForbiddenRegion();
            Iterator<ForbiddenRegion> forbiddenRegionIterator  = cons.getFirstForbiddenRegions().iterator();
            while(forbiddenRegionIterator.hasNext()){
                ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
               /* int minValue = Math.max(structure.getDomain().getMinX(), forbiddenRegion.getMinX()) ;
                QEvent event = new QEvent(true, forbiddenRegion,cons, minValue);
                qEvents.add(event);
                if(forbiddenRegion.getMaxX()+1<= structure.getDomain().getMaxX()){
                    QEvent eventEnd = new QEvent(false, forbiddenRegion,cons, forbiddenRegion.getMaxX()+1);
                    qEvents.add(event);
                }*/
                //replace by
                addForbiddenRegionToQEvent(forbiddenRegion, cons);
            }

        }
        Collections.sort(qEvents);
        //if qevent is empty or the first x is free
        if(qEvents.size() == 0 || qEvents.get(0).getMinX() > structure.getDomain().getMinX() ){
            return new Point(structure.getDomain().getMinX(), (int) (Math.random()*(structure.getDomain().getMaxY() - structure.getDomain().getMinY())) + structure.getDomain().getMinY());
        } else {
            nbZeroInPStatus = structure.getDomain().getMaxY() - structure.getDomain().getMinY()+1;
            int[] pStatus = new int[structure.getDomain().getMaxY() - structure.getDomain().getMinY()+1];
            for(int i= 0; i < pStatus.length; i++){
                pStatus[i] = 0;
            }
            //TODO manage 1 to PStatus
            while (qEvents.size() != 0){
                int delta = qEvents.get(0).getMinX();
                while(qEvents.size() > 0 && Math.max(structure.getDomain().getMinX(),qEvents.get(0).getMinX()) == delta){

                    handleEvent(qEvents.get(0), pStatus);
                }
                if(nbZeroInPStatus > 0){
                    int[] possibleValues = new int[nbZeroInPStatus];
                    int compteur = 0;
                    for(int i =0; i< pStatus.length; i++){
                        if(pStatus[i] == 0){
                            possibleValues[compteur] = i;
                            compteur++;
                        }
                    }
                    int y = possibleValues[(int)(Math.random()*possibleValues.length)]+structure.getDomain().getMinY();
                    return  new Point(delta, y);
                }



            }
        }
        throw new Exception("no point was found");
    }

    public void handleEvent(QEvent qEvent, int[] pStatus){
        qEvents.remove(0);
        int l = Math.max(structure.getDomain().getMinY(), qEvent.getForbiddenRegion().getMinY());
        int u = Math.min(structure.getDomain().getMaxY(), qEvent.getForbiddenRegion().getMaxY());
        if(qEvent.isStart()){ 
            //add 1 to pStatus[u<=i<=i]
            int dif = u -l+1;
            for(int i = 0; i<dif; i++){
                pStatus[(i+l) - structure.getDomain().getMinY()] +=1  ;

                if(pStatus[(i+l) - structure.getDomain().getMinY()] == 1){
                    nbZeroInPStatus--;
                }
            }
            if(!isQEventsContainsEventForConstraint(qEvent.getConstraint())){
                Iterator<ForbiddenRegion> forbiddenRegionIterator  = qEvent.getConstraint().getNextForbiddenRegions().iterator();
                while(forbiddenRegionIterator.hasNext()){
                    ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
                    addForbiddenRegionToQEvent(forbiddenRegion, qEvent.getConstraint());
                }
            }

        }else{
            int dif = u - l +1;
            for(int i = 0; i<dif; i++){
                pStatus[ (i+l) - structure.getDomain().getMinY()] -= 1;
                if(pStatus[ (i+l) - structure.getDomain().getMinY()] == 0){
                    nbZeroInPStatus++;
                }
            }
        }
    }

    public void addForbiddenRegionToQEvent(ForbiddenRegion forbiddenRegion, Constraint cons){
        int minValue = Math.max(structure.getDomain().getMinX(), forbiddenRegion.getMinX()) ;
        QEvent event = new QEvent(true, forbiddenRegion,cons, minValue);
        qEvents.add(event);
        if(forbiddenRegion.getMaxX()+1<= structure.getDomain().getMaxX()){
            QEvent eventEnd = new QEvent(false, forbiddenRegion,cons, forbiddenRegion.getMaxX()+1);
            qEvents.add(eventEnd);
        }
    }
    public boolean isQEventsContainsEventForConstraint(Constraint constraint){
        for(int i = 0; i<qEvents.size(); i++){
            if(qEvents.get(i).getConstraint().equals(constraint)){
                return true;
            }
        }
        return false;
    }
}
