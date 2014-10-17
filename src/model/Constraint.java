package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by math.herbert on 17/10/14.
 */
public class Constraint {
    private List<ForbiddenRegion> forbiddenRegions;

    public Constraint(){
        this.forbiddenRegions =  new ArrayList<ForbiddenRegion>();
    }

    public void addForbiddenRegion(ForbiddenRegion forbiddenRegion){
        this.forbiddenRegions.add(forbiddenRegion);
    }

    public List<ForbiddenRegion> getForbiddenRegions(){
        return this.forbiddenRegions;
    }

    public void orderForbiddenRegion(){
        Collections.sort(forbiddenRegions);
    }
}
