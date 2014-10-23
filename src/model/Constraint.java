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

    private String name;
    public Constraint(Domain domain, String name){
        this.forbiddenRegions =  new ArrayList<ForbiddenRegion>();
        this.domain = domain;
        this.name = name;
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
        boolean find = false;
        currentXMin = -1;
        int pos = -1;
        for (int i = 0; i<forbiddenRegions.size(); i++){
            if(forbiddenRegions.get(i).getMaxX() >= domain.getMinX() && forbiddenRegions.get(i).getMinX() <= domain.getMaxX()  ){
                currentXMin = Math.max(forbiddenRegions.get(i).getMinX(), domain.getMinX());
                pos = i;
                break;
            }
        }
        if(pos == -1){
            return  firstForbiddenRegions;
        }
        for (int i = pos; i<forbiddenRegions.size(); i++){
            currentPosition = i;
            if(Math.max(forbiddenRegions.get(i).getMinX(), domain.getMinX()) == currentXMin){
                firstForbiddenRegions.add(forbiddenRegions.get(i));
            }else{
                break;
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

    public boolean checkIfInForbiddenRegions(int x, int y){
        for (ForbiddenRegion forbiddenRegion : forbiddenRegions){
            if(forbiddenRegion.checkIfInForbiddenRegion(x,y)){
                return true;
            }
        }
        return false;
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

    @Override
    public String toString() {
        return "Constraint{" +
                "domain=" + domain +
                ", forbiddenRegions=" + forbiddenRegions +
                ", currentXMin=" + currentXMin +
                ", currentPosition=" + currentPosition +
                ", name='" + name + '\'' +
                '}';
    }
}
