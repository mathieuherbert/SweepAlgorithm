package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Define a Constraint
 * A constraint can have multiple forbiddenRegions
 */
public class Constraint {
    private final Domain domain;
    private List<ForbiddenRegion> forbiddenRegions;


    private int currentValue = Integer.MAX_VALUE;
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

    /**
     * Get the first forbidden region from the list
     * @param external the external dimension
     * @param isMax if it's from max or min value
     * @return
     */
    public List<ForbiddenRegion> getFirstForbiddenRegions(Dimension external, boolean isMax){
        List<ForbiddenRegion> firstForbiddenRegions = new ArrayList<ForbiddenRegion>();
        boolean find = false;
        currentValue = -1;
        int pos = -1;
        for (int i = 0; i<forbiddenRegions.size(); i++){
            if(forbiddenRegions.get(i).getMaxExternal() >= domain.getValue(external, false) && forbiddenRegions.get(i).getMinExternal() <= domain.getValue(external,true) ){
            //if(forbiddenRegions.get(i).getMaxX() >= domain.getMinX() && forbiddenRegions.get(i).getMinX() <= domain.getMaxX()  ){
                //currentXMin = Math.max(forbiddenRegions.get(i).getMinX(), domain.getMinX());
                if(isMax)
                    currentValue = Math.min(forbiddenRegions.get(i).getMaxExternal(), domain.getValue(external,isMax));
                else{
                    currentValue = Math.max(forbiddenRegions.get(i).getMinExternal(), domain.getValue(external,isMax));
                }
                pos = i;
                break;
            }
        }
        if(pos == -1){
            return  firstForbiddenRegions;
        }
        for (int i = pos; i<forbiddenRegions.size(); i++){
            currentPosition = i;
            if(isMax && (Math.min(forbiddenRegions.get(i).getMaxExternal(), domain.getValue(external,isMax)) == currentValue)){

                firstForbiddenRegions.add(forbiddenRegions.get(i));

            }else if(!isMax && (Math.max(forbiddenRegions.get(i).getMinExternal(), domain.getValue(external,isMax)) == currentValue)){

                firstForbiddenRegions.add(forbiddenRegions.get(i));

            }else {
                break;
            }

        }
        return firstForbiddenRegions;
    }

    public List<ForbiddenRegion> getNextForbiddenRegions(Dimension external, boolean isMax){
        if(currentPosition == Integer.MAX_VALUE){
            return getFirstForbiddenRegions(external, isMax);
        }
        List<ForbiddenRegion> nextForbiddenRegions = new ArrayList<ForbiddenRegion>();
        if(forbiddenRegions.size() >= (currentPosition+1)){
            return nextForbiddenRegions;
        }
        if(isMax)
            currentValue = Math.min(forbiddenRegions.get(currentPosition+1).getMaxExternal(), domain.getValue(external,isMax));
        else{
            currentValue = Math.max(forbiddenRegions.get(currentPosition+1).getMinExternal(), domain.getValue(external,isMax));
        }
        //currentXMin = Math.max(forbiddenRegions.get(currentPosition+1).getMinX(), domain.getMinX());
        for (int i = (currentPosition+1); i<forbiddenRegions.size(); i++){

            if((isMax && (Math.min(forbiddenRegions.get(i).getMaxExternal(), domain.getValue(external,isMax)) == currentValue))
                    || (!isMax && (Math.max(forbiddenRegions.get(i).getMinExternal(), domain.getValue(external,isMax)) == currentValue))){

                nextForbiddenRegions.add(forbiddenRegions.get(i));


            }else {
                currentPosition = i;
                break;
            }

        }
        return nextForbiddenRegions;
    }

    /**
     * check if (external,internal) is in a forbidden region
     * @param external external value
     * @param internal internal value
     * @return true if in forbidden region
     */
    public boolean checkIfInForbiddenRegions(int external, int internal){
        for (ForbiddenRegion forbiddenRegion : forbiddenRegions){
            if(forbiddenRegion.checkIfInForbiddenRegion(external,internal)){
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
        if (currentValue != that.currentValue) return false;
        if (domain != null ? !domain.equals(that.domain) : that.domain != null) return false;
        if (forbiddenRegions != null ? !forbiddenRegions.equals(that.forbiddenRegions) : that.forbiddenRegions != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = domain != null ? domain.hashCode() : 0;
        result = 31 * result + (forbiddenRegions != null ? forbiddenRegions.hashCode() : 0);
        result = 31 * result + currentValue;
        result = 31 * result + currentPosition;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "domain=" + domain +
                ", forbiddenRegions=" + forbiddenRegions +
                ", currentValue=" + currentValue +
                ", currentPosition=" + currentPosition +
                ", name='" + name + '\'' +
                '}';
    }
}
