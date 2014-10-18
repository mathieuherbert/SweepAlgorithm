package model;

import java.util.List;

/**
 * Created by math.herbert on 17/10/14.
 */
public class DataStructure {

    private List<Constraint> constraints;

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
