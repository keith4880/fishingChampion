/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Keith Downing
 */
public class Scene implements Serializable{
    // class instance variables
    private String description;
    private String travelTime;
    private double displaySymbol;
    private String clue;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public double getDisplaySymbol() {
        return displaySymbol;
    }

    public void setDisplaySymbol(double displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.travelTime);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.displaySymbol) ^ (Double.doubleToLongBits(this.displaySymbol) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.clue);
        return hash;
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", travelTime=" + travelTime + ", displaySymbol=" + displaySymbol + ", clue=" + clue + '}';
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
        final Scene other = (Scene) obj;
        if (Double.doubleToLongBits(this.displaySymbol) != Double.doubleToLongBits(other.displaySymbol)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.travelTime, other.travelTime)) {
            return false;
        }
        if (!Objects.equals(this.clue, other.clue)) {
            return false;
        }
        return true;
    }
    
    
    public Scene() {
    }
    
    
}
