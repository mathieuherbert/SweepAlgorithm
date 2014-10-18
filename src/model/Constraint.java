package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by math.herbert on 17/10/14.
 */
public class Constraint {
    private final Domain domain;
    private List<ForbiddenRegion> forbiddenRegions;

    private int currentXMin = Integer.MAX_VALUE;
    private int currentPosition = Integer.MAX_VALUE;

    public Constraint(Domain domain){
        this.forbiddenRegions =  new ArrayList<ForbiddenRegion>();
        this.domain = domain;
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
    //the forbiddenRegions need to be ordered before executing this method
    public List<ForbiddenRegion> getFirstForbiddenRegions(){
        List<ForbiddenRegion> firstForbiddenRegions = new ArrayList<ForbiddenRegion>();
        currentXMin = Math.max(forbiddenRegions.get(0).getMinX(), domain.getMinX());
        for (int i = 0; i<forbiddenRegions.size(); i++){
            if(Math.max(forbiddenRegions.get(i).getMinX(), domain.getMinX()) == currentXMin){
                firstForbiddenRegions.add(forbiddenRegions.get(i));
            }else{
                currentPosition = i;
            }
        }
        return firstForbiddenRegions;
    }

    public List<ForbiddenRegion> getNextForbiddenRegions(){
        if(currentPosition == Integer.MAX_VALUE){
            return getFirstForbiddenRegions();
        }
        List<ForbiddenRegion> nextForbiddenRegions = new ArrayList<ForbiddenRegion>();
        if(forbiddenRegions.size() >= (currentPosition+1)){
            return nextForbiddenRegions;
        }
        currentXMin = Math.max(forbiddenRegions.get(currentPosition+1).getMinX(), domain.getMinX());
        for (int i = (currentPosition+1); i<forbiddenRegions.size(); i++){
            if(Math.max(forbiddenRegions.get(i).getMinX(), domain.getMinX()) == currentXMin){
                nextForbiddenRegions.add(forbiddenRegions.get(i));
            }else{
                currentPosition = i;
            }
        }
        return nextForbiddenRegions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Constraint that = (Constraint) o;

        if (currentPosition != that.currentPosition) return false;
        if (currentXMin != that.currentXMin) return false;
        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (forbiddenRegions != null ? !forbiddenRegions.equals(that.forbiddenRegions) : that.forbiddenRegions != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = domain != null ? domain.hashCode() : 0;
        result = 31 * result + (forbiddenRegions != null ? forbiddenRegions.hashCode() : 0);
        result = 31 * result + currentXMin;
        result = 31 * result + currentPosition;
        return result;
    }
}
