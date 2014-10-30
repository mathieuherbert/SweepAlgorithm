package algorithm;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by math.herbert on 29/10/14.
 */
public class Sweep {


    private boolean isMax;
    private Dimension dimensionInternal;
    private Dimension dimensionExternal;

    List<QEvent> qEvents;

    DataStructure structure;

    int nbZeroInPStatus;

    public Sweep(DataStructure structure, Dimension internal, Dimension external, boolean isMax ){
        this.structure = structure;
        qEvents = new ArrayList<QEvent>();
        nbZeroInPStatus = 0;
        this.dimensionInternal = internal;
        this.dimensionExternal = external;
        this.isMax = isMax;
    }

    public Point find()  {

        Iterator<Constraint> itConstraints = structure.getConstraints().iterator();

        //for each constraint add forbidden regions to a qevent
        while(itConstraints.hasNext()){
            Constraint cons = itConstraints.next();
            cons.orderForbiddenRegion();
            Iterator<ForbiddenRegion> forbiddenRegionIterator  = cons.getFirstForbiddenRegions(dimensionExternal, isMax).iterator();
            while(forbiddenRegionIterator.hasNext()){
                ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
                addForbiddenRegionToQEvent(forbiddenRegion, cons);
            }

        }
        if(isMax)
            Collections.sort(qEvents, Collections.reverseOrder());
        else {
            Collections.sort(qEvents);
        }

        //if qevent is empty or the first x is free
        if(qEvents.size() == 0 || (!isMax && qEvents.get(0).getValue() > structure.getDomain().getValue(dimensionExternal,isMax))
                ||(isMax && qEvents.get(0).getValue() < structure.getDomain().getValue(dimensionExternal, isMax)) ){
            return new Point(structure.getDomain().getValue(dimensionExternal, isMax),
                    (int) (Math.random()*(structure.getDomain().getValue(dimensionInternal, true)
                            - structure.getDomain().getValue(dimensionInternal, false)+1))
                            + structure.getDomain().getValue(dimensionInternal, false), true);
        } else {
            nbZeroInPStatus = structure.getDomain().getValue(dimensionInternal, true)
                    - structure.getDomain().getValue(dimensionInternal,false)+1;
            int[] pStatus = new int[structure.getDomain().getValue(dimensionInternal, true)
                    - structure.getDomain().getValue(dimensionInternal, false)+1];
            while (qEvents.size() != 0){
                if(isMax)
                    Collections.sort(qEvents, Collections.reverseOrder());
                else {
                    Collections.sort(qEvents);

                }
                int delta = qEvents.get(0).getValue();
                while(qEvents.size() > 0 && ( (isMax && Math.min(structure.getDomain().getValue(dimensionExternal,isMax),qEvents.get(0).getValue()) ==delta) ||
                        (!isMax && Math.max(structure.getDomain().getValue(dimensionExternal,isMax),qEvents.get(0).getValue()) == delta))) {
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
                    int possibleInternalValue = possibleValues[(int)(Math.random()*possibleValues.length)]+structure.getDomain().getValue(dimensionInternal, false);
                    return  new Point(delta, possibleInternalValue, true);
                }



            }
        }

        return new Point (0,0,false);
    }

    public void handleEvent(QEvent qEvent, int[] pStatus){
        qEvents.remove(0);
        int l = Math.max(structure.getDomain().getValue(dimensionInternal,false), qEvent.getForbiddenRegion().getMinInternal());
        int u = Math.min(structure.getDomain().getValue(dimensionInternal, true), qEvent.getForbiddenRegion().getMaxInternal());
        //if qevent is a start event, we add 1 to pstatus between l and u and we are looking for the next forbidden regions
        if(qEvent.isStart()){
            //add 1 to pStatus[u<=i<=i]
            int dif = u -l+1;
            for(int i = 0; i<dif; i++){
                pStatus[(i+l) - structure.getDomain().getValue(dimensionInternal, false)] +=1  ;

                if(pStatus[(i+l) - structure.getDomain().getValue(dimensionInternal, false)] == 1){
                    nbZeroInPStatus--;
                }
            }
            if(!isQEventsContainsEventForConstraint(qEvent.getConstraint())){
                Iterator<ForbiddenRegion> forbiddenRegionIterator  = qEvent.getConstraint().getNextForbiddenRegions(dimensionExternal,isMax).iterator();
                while(forbiddenRegionIterator.hasNext()){
                    ForbiddenRegion forbiddenRegion = forbiddenRegionIterator.next();
                    addForbiddenRegionToQEvent(forbiddenRegion, qEvent.getConstraint());
                }
            }

        }else{
            int dif = u - l +1;
            for(int i = 0; i<dif; i++){
                pStatus[ (i+l) - structure.getDomain().getValue(dimensionInternal, false)] -= 1;
                if(pStatus[ (i+l) - structure.getDomain().getValue(dimensionInternal, false)] == 0){
                    nbZeroInPStatus++;
                }
            }
        }
    }

    public void addForbiddenRegionToQEvent(ForbiddenRegion forbiddenRegion, Constraint cons){
       int value = isMax?Math.min(structure.getDomain().getValue(dimensionExternal, isMax), forbiddenRegion.getMaxExternal()):
               Math.max(structure.getDomain().getValue(dimensionExternal, isMax), forbiddenRegion.getMinExternal());
     

        QEvent event = new QEvent(true, forbiddenRegion,cons, value );
        qEvents.add(event);
        if(!isMax && forbiddenRegion.getMaxExternal()+1<= structure.getDomain().getValue(dimensionExternal,true)){
            QEvent eventEnd = new QEvent(false, forbiddenRegion,cons, forbiddenRegion.getMaxExternal()+1);
            qEvents.add(eventEnd);
        }else if(isMax && forbiddenRegion.getMinExternal()-1>= structure.getDomain().getValue(dimensionExternal,false)){
            QEvent eventEnd = new QEvent(false, forbiddenRegion,cons, forbiddenRegion.getMinExternal()-1);
            qEvents.add(eventEnd);
        }
    }
    public boolean isQEventsContainsEventForConstraint(Constraint constraint){
        for(QEvent qEvent : qEvents){
            if(qEvent.getConstraint().equals(constraint)){
                return true;
            }
        }
        return false;
    }

}
