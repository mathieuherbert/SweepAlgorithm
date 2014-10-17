package model;

import java.util.List;

/**
 * Created by math.herbert on 17/10/14.
 */
public class DataStructure {

    private List<Constraint> constraints;

    private Domain domain;

    private PlacementDomain placementDomain;

    public DataStructure(List<Constraint> constraints, Domain domain, PlacementDomain placementDomain){
        this.constraints = constraints;
        this.domain = domain;
        this.placementDomain = placementDomain;
    }

    public List<Constraint> getConstraints(){
        return this.constraints;
    }

    public Domain getDomain(){
        return this.domain;
    }
}
