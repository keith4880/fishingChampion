/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import byui.cit260.fishingChampion.model.Player;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class GameMenuView extends View {
    public GameMenuView() {
        super("\n----------------------------------------"
            + "\n| Game Menu                            |"
            + "\n----------------------------------------"
            + "\nC - Cast a Line"
            + "\nM - View Map"
            + "\nL - Look Around"
            + "\nB - Check Boat"
            + "\nS - Enter Marina Shop"
            + "\nI - Interpret Clue"
            + "\nQ - Return to Main Menu"
            + "\n----------------------------------------"
            + "\nPlease select an option using the keyboard.");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "C":
                this.castLine();
                break;
            case "M":
                this.viewMap();
                break;
            case "L":
                this.lookAround();
                break;
            case "B":
                this.checkBoat();
                break;
            case "S":
                this.enterShop();
                break;
            case "I":
                this.clueView();
                break;
            default:
                System.out.println("\n*** Please enter a valid selection.");
                break;
        }
        return false;
    }
    
    private void enterShop() {
        ShopView shopView = new ShopView();
        shopView.display();
    }
    private void clueView() {
        ClueView clueView = new ClueView();
        clueView.displayClueView();
    }
    private void castLine() {
        FishingView fishView = new FishingView();
        fishView.castLine();
    }
    private void viewMap() {
        MapView mapView = new MapView();
        mapView.viewMap();
    }
    private void lookAround() {
        AreaView areaView = new AreaView();
        areaView.viewArea();
    }
    private void checkBoat() {
        Game game = FishingChampion.getCurrentGame();
        Player player = game.getPlayer();
        InventoryItem[] inventory = game.getInventoryItem();
        System.out.println(player.getName());
        System.out.println("Money = " + inventory[Game.Item.money.ordinal()].getAmount());
        System.out.println("Fuel = " + inventory[Game.Item.fuel.ordinal()].getAmount());
        System.out.println("Fish = " + inventory[Game.Item.fish.ordinal()].getAmount());
        System.out.println("Bait = " + inventory[Game.Item.bait.ordinal()].getAmount() + "/" + inventory[Game.Item.bait.ordinal()].getMaxAmout());
        System.out.println("Fuel Efficiency = " + inventory[Game.Item.fuelEfficiency.ordinal()].getAmount());
        System.out.println("Maximum Weight = " + inventory[Game.Item.maxWeight.ordinal()].getAmount());
    }
}
