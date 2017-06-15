/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Boat;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.Shop;
import byui.cit260.fishingChampion.model.TackleBox;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class ShopControl {

    public static int buyBait() {
        Game game = FishingChampion.getCurrentGame();
        Player player = game.getPlayer();
        TackleBox tackleBox = game.getTackleBox();
        Shop shop = new Shop();
        int baitCost = shop.getBaitCost();
        double money = player.getMoneyAmount();
        if (money < baitCost) {
            return 0;
        } else if (tackleBox.getAmountContained() >= tackleBox.getMaxAmount()) {
            return -1;
        } else {
            tackleBox.setAmountContained(tackleBox.getAmountContained() + 1);
            player.setMoneyAmount(money - baitCost);
            return 1;
        }
    }

    
}
