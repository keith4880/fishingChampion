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
public class InventoryItem implements Serializable {
    private int amount;
    private int maxAmount;
    
    public int getAmount(){
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getMaxAmout() {
        return maxAmount;
    }
    
    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }
}
