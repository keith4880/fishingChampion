/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import byui.cit260.fishingChampion.model.Purchase;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class ShopControl {
    
    private static InventoryItem[] inventory;
    
    public static InventoryItem[] viewInventory() {
        Game game = FishingChampion.getCurrentGame();
        inventory = game.getInventoryItem();
        return inventory;
    }

    public static int buySell(int item) {
        Game game = FishingChampion.getCurrentGame();
        inventory = game.getInventoryItem();
        Purchase[] purchase = ShopControl.createPurchase();
        int cost = purchase[item].getPrice();
        int money = inventory[Game.Item.money.ordinal()].getAmount();
        if (money < cost) {
            return 0;
        } else if (item == Game.Item.fish.ordinal() && inventory[item].getAmount() < 1) {
            return 0;
        } else if (ShopControl.checkMax(item) == false) {
            return -1;
        } else {
            inventory[item].setAmount(inventory[item].getAmount() + purchase[item].getAmount());
            inventory[Game.Item.money.ordinal()].setAmount(money - cost);
            return 1;
        }
    }

    private static Purchase[] createPurchase() {
        Purchase[] purchase = new Purchase[6];
        
        Purchase fish = new Purchase();
        fish.setPrice(-20);
        fish.setAmount(-10);
        purchase[Game.Item.fish.ordinal()] = fish;
        
        Purchase fuel = new Purchase();
        fuel.setPrice(10);
        fuel.setAmount(10);
        purchase[Game.Item.fuel.ordinal()] = fuel;
        
        Purchase bait = new Purchase();
        bait.setPrice(10);
        bait.setAmount(1);
        purchase[Game.Item.bait.ordinal()] = bait;
        
        Purchase maxWeight = new Purchase();
        maxWeight.setPrice(100);
        maxWeight.setAmount(50);
        purchase[Game.Item.maxWeight.ordinal()] = maxWeight;
        
        Purchase fuelEfficiency = new Purchase();
        fuelEfficiency.setPrice(100);
        fuelEfficiency.setAmount(1);
        purchase[Game.Item.fuelEfficiency.ordinal()] = fuelEfficiency;
        
        return purchase;
    }

    private static boolean checkMax(int item) {
        Game game = FishingChampion.getCurrentGame();
        inventory = game.getInventoryItem();
        if (item == Game.Item.fuel.ordinal()) {
            return inventory[Game.Item.fish.ordinal()].getAmount() + inventory[Game.Item.fuel.ordinal()].getAmount() + 10 <= inventory[Game.Item.maxWeight.ordinal()].getAmount();
        } else {
            return inventory[item].getAmount() + 1 <= inventory[item].getMaxAmout();
        } 
    }

    
}
