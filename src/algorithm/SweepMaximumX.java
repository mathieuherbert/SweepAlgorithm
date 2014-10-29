package algorithm;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by math.herbert on 29/10/14.
 */
public class SweepMaximumX {

//    List<QEvent> qEvents;
//
//    DataStructure structure;
//
//    int nbZeroInPStatus;
//
//    public SweepMaximumX(DataStructure structure){
//        this.structure = structure;
//        qEvents = new ArrayList<QEvent>();
//        nbZeroInPStatus = 0;
//    }
//
//    public Point findMaximum()  {
//
//        Iterator<Constraint> itConstraints = structure.getConstraints().iterator();
//
//        //for each constraint add forbidden regions to a qevent
//        while(itConstraints.hasNext()){
//            Constraint cons = itConstraints.next();
//            cons.orderForbiddenRegion();
//            Iterator<ForbiddenRegion> forbiddenRegionIterator  = cons.getFirstForbiddenRegions().iterator();
//            while(forbiddenRegionIterator.hasNext()){
//                ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
//                addForbiddenRegionToQEvent(forbiddenRegion, cons);
//            }
//
//        }
//        Collections.sort(qEvents, Collections.reverseOrder());
//        for(QEvent q : qEvents)
//            System.out.println(q.getValue());
//
//        //if qevent is empty or the first x is free
//        if(qEvents.size() == 0 || qEvents.get(0).getValue() < structure.getDomain().getMaxX() ){
//            System.out.println("passage point");
//            return new Point(structure.getDomain().getMaxX(), (int) (Math.random()*(structure.getDomain().getMaxY() - structure.getDomain().getMinY()+1)) + structure.getDomain().getMinY(), true);
//        } else {
//            nbZeroInPStatus = structure.getDomain().getMaxY() - structure.getDomain().getMinY()+1;
//            int[] pStatus = new int[structure.getDomain().getMaxY() - structure.getDomain().getMinY()+1];
//            while (qEvents.size() != 0){
//                Collections.sort(qEvents, Collections.reverseOrder());
//                int delta = qEvents.get(0).getValue();
//                while(qEvents.size() > 0 && Math.min(structure.getDomain().getMaxX(), qEvents.get(0).getValue()) == delta){
//
//                    handleEvent(qEvents.get(0), pStatus);
//                }
//                if(nbZeroInPStatus > 0){
//                    int[] possibleValues = new int[nbZeroInPStatus];
//                    int compteur = 0;
//                    for(int i =0; i< pStatus.length; i++){
//                        if(pStatus[i] == 0){
//                            possibleValues[compteur] = i;
//                            compteur++;
//                        }
//                    }
//                    int y = possibleValues[(int)(Math.random()*possibleValues.length)]+structure.getDomain().getMinY();
//                    return  new Point(delta, y, true);
//                }
//            }
//        }
//        return new Point (0,0,false);
//    }
//
//    public void handleEvent(QEvent qEvent, int[] pStatus){
//        qEvents.remove(0);
//        int l = Math.max(structure.getDomain().getMinY(), qEvent.getForbiddenRegion().getMinY());
//        int u = Math.min(structure.getDomain().getMaxY(), qEvent.getForbiddenRegion().getMaxY());
//        //if qevent is a start event, we add 1 to pstatus between l and u and we are looking for the next forbidden regions
//        if(qEvent.isStart()){
//            //add 1 to pStatus[u<=i<=i]
//            int dif = u -l+1;
//            for(int i = 0; i<dif; i++){
//                pStatus[(i+l) - structure.getDomain().getMinY()] +=1  ;
//
//                if(pStatus[(i+l) - structure.getDomain().getMinY()] == 1){
//                    nbZeroInPStatus--;
//                }
//            }
//            if(!isQEventsContainsEventForConstraint(qEvent.getConstraint())){
//                Iterator<ForbiddenRegion> forbiddenRegionIterator  = qEvent.getConstraint().getNextForbiddenRegions().iterator();
//                while(forbiddenRegionIterator.hasNext()){
//                    ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
//                    addForbiddenRegionToQEvent(forbiddenRegion, qEvent.getConstraint());
//                }
//            }
//
//        }else{
//            int dif = u - l +1;
//            for(int i = 0; i<dif; i++){
//                pStatus[ (i+l) - structure.getDomain().getMinY()] -= 1;
//                if(pStatus[ (i+l) - structure.getDomain().getMinY()] == 0){
//                    nbZeroInPStatus++;
//                }
//            }
//        }
//    }
//
//    public void addForbiddenRegionToQEvent(ForbiddenRegion forbiddenRegion, Constraint cons){
//        int minValue = Math.max(structure.getDomain().getMinX(), forbiddenRegion.getMinX()) ;
//        QEvent event = new QEvent(true, forbiddenRegion,cons, minValue);
//        qEvents.add(event);
//        if(forbiddenRegion.getMinX()-1>= structure.getDomain().getMinX()){
//            QEvent eventEnd = new QEvent(false, forbiddenRegion,cons, forbiddenRegion.getMinX()-1);
//            qEvents.add(eventEnd);
//        }
//    }
//    public boolean isQEventsContainsEventForConstraint(Constraint constraint){
//        for(QEvent qEvent : qEvents){
//            if(qEvent.getConstraint().equals(constraint)){
//                return true;
//            }
//        }
//        return false;
//    }
}
