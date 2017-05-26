/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishingchampion;

import byui.cit260.fishingChampion.model.Shop;

/**
 *
 * @author Keith Downing
 */
public class FishingChampion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Shop shop = new Shop();
        
        shop.setFishPrice(10);
        shop.setBaitCost(5);
        shop.setFuelCost(20);
        shop.setUpgradeFuelCost(50);
        shop.setUpgradeSizeCost(50);
        String itemInfo = shop.toString();
        System.out.println(itemInfo);
    }
    
}
