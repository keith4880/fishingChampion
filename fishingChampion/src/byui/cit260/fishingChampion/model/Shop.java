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
public class Shop implements Serializable{
    
    private int fishPrice;
    private int fuelCost;
    private int baitCost;
    private int upgradeSizeCost;
    private int upgradeFuelCost;

    public Shop() {
    }
    
    

    public int getFishPrice() {
        return fishPrice;
    }

    public void setFishPrice(int fishPrice) {
        this.fishPrice = fishPrice;
    }

    public int getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(int fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getBaitCost() {
        return baitCost;
    }

    public void setBaitCost(int baitCost) {
        this.baitCost = baitCost;
    }

    public int getUpgradeSizeCost() {
        return upgradeSizeCost;
    }

    public void setUpgradeSizeCost(int upgradeSizeCost) {
        this.upgradeSizeCost = upgradeSizeCost;
    }

    public int getUpgradeFuelCost() {
        return upgradeFuelCost;
    }

    public void setUpgradeFuelCost(int upgradeFuelCost) {
        this.upgradeFuelCost = upgradeFuelCost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.fishPrice;
        hash = 59 * hash + this.fuelCost;
        hash = 59 * hash + this.baitCost;
        hash = 59 * hash + this.upgradeSizeCost;
        hash = 59 * hash + this.upgradeFuelCost;
        return hash;
    }

    @Override
    public String toString() {
        return "Shop{" + "fishPrice=" + fishPrice + ", fuelCost=" + fuelCost + ", baitCost=" + baitCost + ", upgradeSizeCost=" + upgradeSizeCost + ", upgradeFuelCost=" + upgradeFuelCost + '}';
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
        final Shop other = (Shop) obj;
        if (this.fishPrice != other.fishPrice) {
            return false;
        }
        if (this.fuelCost != other.fuelCost) {
            return false;
        }
        if (this.baitCost != other.baitCost) {
            return false;
        }
        if (this.upgradeSizeCost != other.upgradeSizeCost) {
            return false;
        }
        if (this.upgradeFuelCost != other.upgradeFuelCost) {
            return false;
        }
        return true;
    }
    
    
    
    
}
