package model;

import java.util.List;

/**
 * DataStructure for the sweep Algorithm
 */
public class DataStructure {
    /**
     * List of constraints
     */
    private List<Constraint> constraints;
    /**
     * The domain for the current rectangle
     */
    private Domain domain;



    public DataStructure(List<Constraint> constraints, Domain domain){
        this.constraints = constraints;
        this.domain = domain;

    }

    public List<Constraint> getConstraints(){
        return this.constraints;
    }

    public Domain getDomain(){
        return this.domain;
    }
}
