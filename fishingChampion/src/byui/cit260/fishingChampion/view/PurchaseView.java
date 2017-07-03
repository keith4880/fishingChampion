/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.ShopControl;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import exceptions.PurchaseControlException;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class PurchaseView extends View {
    
    public PurchaseView(int itemType) {
        super ("\nType the desired amount of " + (Game.Item.values()[itemType]) + " using the keyboard."
             + "\nQ to retun to shop.");
    }
    
    private String item;

    void showAmount(int type) {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        this.item = Game.Item.values()[type].name();
        this.console.println(item + " = " + inventory[Game.Item.valueOf(item).ordinal()].getAmount());
        this.console.println("\nMoney = " + inventory[Game.Item.money.ordinal()].getAmount());
    }

    @Override
    public boolean doAction(String choice) {
        int amount;
        try {
            amount = Integer.parseInt(choice);
        }
        catch(NumberFormatException nFE) {
            ErrorView.display(this.getClass().getName(),
                    "Please enter a valid selection." + nFE.getMessage());
            return false;
        }
        try {
            ShopControl.buySell(Game.Item.valueOf(item).ordinal(), amount);
        }
        catch(PurchaseControlException pCE) {
            ErrorView.display(this.getClass().getName(),
                    pCE.getMessage());
            return false;
        }
        return true;
    }
    
    
    
}
