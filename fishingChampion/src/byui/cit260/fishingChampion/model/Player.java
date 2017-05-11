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
public class Player implements Serializable{
    
    //class instance variables
    private String name;
    private double bestTime;
    private double moneyAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBestTime() {
        return bestTime;
    }

    public void setBestTime(double bestTime) {
        this.bestTime = bestTime;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.name);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.bestTime) ^ (Double.doubleToLongBits(this.bestTime) >>> 32));
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.moneyAmount) ^ (Double.doubleToLongBits(this.moneyAmount) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", bestTime=" + bestTime + ", moneyAmount=" + moneyAmount + '}';
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
        final Player other = (Player) obj;
        if (Double.doubleToLongBits(this.bestTime) != Double.doubleToLongBits(other.bestTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.moneyAmount) != Double.doubleToLongBits(other.moneyAmount)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    public Player() {
    }
    
    
}
