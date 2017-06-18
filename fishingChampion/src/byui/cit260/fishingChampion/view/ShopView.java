package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.ShopControl;
import byui.cit260.fishingChampion.model.Game;

/**
 *
 * @author brax10
 */
public class ShopView extends View {
    
    public ShopView() {
            super("\n----------------------------------------"
                + "\n Marina Shop                           |"
                + "\n----------------------------------------"
                + "\nB - Buy 1 Bait                        10"
                + "\nF - Buy 10 Fuel                       10"
                + "\nE - Upgrade Boat's Fuel Efficiency   100"
                + "\nM - Upgrade Boat's Maximum Weight    100"
                + "\nS - Sell 10 Pounds of Fish            20"
                + "\nQ - Exit Shop                       Free"
                + "\n----------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "B":
                this.buyBait();
                break;
            case "F":
                this.buyFuel();
                break;
            case "E":
                this.upgradeFuelEfficiency();
                break;
            case "M":
                this.upgradeMaxWeight();
                break;
            case "S":
                this.sellFish();
                break;
            default:
                System.out.println("\n*** Please enter a valid selection.");
                break;
        }
        return false;
    }

    private void buyBait() {
        int buy;
        buy = ShopControl.buySell(Game.Item.bait.ordinal());
        switch (buy) {
            case 0:
                System.out.println("Not enough money.");
                break;
            case -1:
                System.out.println("You can't carry any more bait.");
                break;
            case 1:
                System.out.println("Bait purchased.");
                break;
        }
    }

    private void buyFuel() {
        int buy;
        buy = ShopControl.buySell(Game.Item.fuel.ordinal());
        switch (buy) {
            case 0:
                System.out.println("Not enough money.");
                break;
            case -1:
                System.out.println("Your boat can't carry that much weight.");
                break;
            case 1:
                System.out.println("Fuel purchased.");
                break;
        }
    }

    private void upgradeFuelEfficiency() {
        int buy;
        buy = ShopControl.buySell(Game.Item.fuelEfficiency.ordinal());
        switch (buy) {
            case 0:
                System.out.println("Not enough money.");
                break;
            case -1:
                System.out.println("Fuel efficiency technology has unfortunately reached its limit.");
                break;
            case 1:
                System.out.println("Boat upgraded.");
                break;
        }
    }
    
    private void upgradeMaxWeight() {
        int buy;
        buy = ShopControl.buySell(Game.Item.maxWeight.ordinal());
        switch (buy) {
            case 0:
                System.out.println("Not enough money.");
                break;
            case -1:
                System.out.println("Your boat would be too large to fit in the lake.");
                break;
            case 1:
                System.out.println("Boat upgraded.");
                break;
        }
    }

    private void sellFish() {
        int buy;
        buy = ShopControl.buySell(Game.Item.fish.ordinal());
        switch (buy) {
            case 0:
                System.out.println("You don't have any fish to sell.");
                break;
            case -1:
                System.out.println("You have too many fish.  You've broken the game.");
                break;
            case 1:
                System.out.println("Fish sold.");
                break;
        }
    }
}
