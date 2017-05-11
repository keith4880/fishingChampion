/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.model;

import java.io.Serializable;

/**
 *
 * @author Keith Downing
 */
public class TackleBox implements Serializable{
    
    //class instance variables.
    private double maxAmount;
    private double amountContained;

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getAmountContained() {
        return amountContained;
    }

    public void setAmountContained(double amountContained) {
        this.amountContained = amountContained;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.maxAmount) ^ (Double.doubleToLongBits(this.maxAmount) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.amountContained) ^ (Double.doubleToLongBits(this.amountContained) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "TackleBox{" + "maxAmount=" + maxAmount + ", amountContained=" + amountContained + '}';
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TackleBox other = (TackleBox) obj;
        if (Double.doubleToLongBits(this.maxAmount) != Double.doubleToLongBits(other.maxAmount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.amountContained) != Double.doubleToLongBits(other.amountContained)) {
            return false;
        }
        return true;
    }
    
    
    public TackleBox() {
    }
    
    
    
}
