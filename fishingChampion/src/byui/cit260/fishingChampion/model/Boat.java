/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.model;

import java.io.Serializable;
        
/**
 *
 * @author kyt09
 */
import java.util.Objects;/**
 *
 * @author kyt09
 */
public class Boat implements Serializable{
    
    private int maxWeight;
    private Double fuelEfficiency;
    private int fuelContained;
    private int fishContained;

    public Boat() {
    }
    
    

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public int getFuelContained() {
        return fuelContained;
    }

    public void setFuelContained(int fuelContained) {
        this.fuelContained = fuelContained;
    }

    public int getFishContained() {
        return fishContained;
    }

    public void setFishContained(int fishContained) {
        this.fishContained = fishContained;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.maxWeight;
        hash = 23 * hash + Objects.hashCode(this.fuelEfficiency);
        hash = 23 * hash + this.fuelContained;
        hash = 23 * hash + this.fishContained;
        return hash;
    }

    @Override
    public String toString() {
        return "Boat{" + "maxWeight=" + maxWeight + ", fuelEfficiency=" + fuelEfficiency + ", fuelContained=" + fuelContained + ", fishContained=" + fishContained + '}';
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
        final Boat other = (Boat) obj;
        if (this.maxWeight != other.maxWeight) {
            return false;
        }
        if (this.fuelContained != other.fuelContained) {
            return false;
        }
        if (this.fishContained != other.fishContained) {
            return false;
        }
        if (!Objects.equals(this.fuelEfficiency, other.fuelEfficiency)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
