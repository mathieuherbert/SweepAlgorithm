package model;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by math.herbert on 17/10/14.
 */
public class Domain {
  private HashMap<Dimension, InternalValuesDomain> domain;

  public Domain(HashMap<Dimension, InternalValuesDomain> domain){
      this.domain = domain;
  }
  public int getValue(Dimension dimension, boolean isMax){
      return isMax?domain.get(dimension).getMax():domain.get(dimension).getMin();
  }


}
