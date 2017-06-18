/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import byui.cit260.fishingChampion.model.Shop;
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

    public static int buyBait() {
        Game game = FishingChampion.getCurrentGame();
        inventory = game.getInventoryItem();
        Shop shop = new Shop();
        int baitCost = shop.getBaitCost();
        int money = inventory[Game.Item.money.ordinal()].getAmount();
        if (money < baitCost) {
            return 0;
        } else if (inventory[Game.Item.bait.ordinal()].getAmount() >= inventory[Game.Item.bait.ordinal()].getMaxAmout()) {
            return -1;
        } else {
            inventory[Game.Item.bait.ordinal()].setAmount(inventory[Game.Item.bait.ordinal()].getAmount() + 1);
            inventory[Game.Item.money.ordinal()].setAmount(money - baitCost);
            return 1;
        }
    }

    
}
