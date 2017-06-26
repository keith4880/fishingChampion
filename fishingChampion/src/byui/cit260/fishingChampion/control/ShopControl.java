/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import exceptions.PurchaseControlException;
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

    public static void buySell(int item, int amount) throws PurchaseControlException {
        Game game = FishingChampion.getCurrentGame();
        inventory = game.getInventoryItem();
        int[] purchase = ShopControl.createPurchase();
        int cost = purchase[item] * amount;
        int money = inventory[Game.Item.money.ordinal()].getAmount();
        if (money < cost) {
            throw new PurchaseControlException("Not enough money.");
        } else if (item == Game.Item.fish.ordinal() && inventory[item].getAmount() < amount) {
            throw new PurchaseControlException("Not enough fish.");
        } else {
            ShopControl.checkMax(item, amount);
            if (item == Game.Item.fish.ordinal()) {
                inventory[item].setAmount(inventory[item].getAmount() - amount);
            } else {
                inventory[item].setAmount(inventory[item].getAmount() + amount);
            }
            inventory[Game.Item.money.ordinal()].setAmount(money - cost);
        }
    }

    private static int[] createPurchase() {
        int[] purchase = new int[6];
        
        int fish = -2;
        purchase[Game.Item.fish.ordinal()] = fish;
        
        int fuel = 1;
        purchase[Game.Item.fuel.ordinal()] = fuel;
        
        int bait = 10;
        purchase[Game.Item.bait.ordinal()] = bait;
        
        int maxWeight = 2;
        purchase[Game.Item.maxWeight.ordinal()] = maxWeight;
        
        int fuelEfficiency = 100;
        purchase[Game.Item.fuelEfficiency.ordinal()] = fuelEfficiency;
        
        return purchase;
    }

    private static void checkMax(int item, int amount) throws PurchaseControlException {
        Game game = FishingChampion.getCurrentGame();
        inventory = game.getInventoryItem();
        if (item == Game.Item.fuel.ordinal() && (inventory[Game.Item.fuel.ordinal()].getAmount() + inventory[Game.Item.fish.ordinal()].getAmount() + amount) > inventory[Game.Item.maxWeight.ordinal()].getAmount()) {
            throw new PurchaseControlException("Your boat can't carry that much weight.");
        } else if (inventory[item].getAmount() > inventory[item].getMaxAmout()) {
            if (item == Game.Item.fuelEfficiency.ordinal()) {
                throw new PurchaseControlException("Fuel efficiency technology has unfortunately reached its limit.");
            } else if (item == Game.Item.maxWeight.ordinal()) {
                throw new PurchaseControlException("Your boat would be too big to fit in the lake.");
            }
        }
            
    }

    
}
