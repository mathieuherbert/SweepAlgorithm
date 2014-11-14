package model;

import java.awt.*;
import java.util.HashMap;

/**
 * A Domain is composed of multiple dimension and IternalValues Domain
 */
public class Domain {
  private HashMap<Dimension, InternalValuesDomain> domain;

  public Domain(HashMap<Dimension, InternalValuesDomain> domain){
      this.domain = domain;
  }

    /**
     * Get the min or max value for a dimension
     * @param dimension the given dimension
     * @param isMax if it's max or min value
     * @return the value
     */
  public int getValue(Dimension dimension, boolean isMax){
      return isMax?domain.get(dimension).getMax():domain.get(dimension).getMin();
  }


}
