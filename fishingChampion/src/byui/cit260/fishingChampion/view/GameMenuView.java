/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.GameControl;
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
            + "\nC - Cast Your Line"
            + "\nM - View the Map"
            + "\nL - Look Around"
            + "\nB - Check the Boat"
            + "\nF - Save Inventory to File"
            + "\nI - Interpret the Clue"
            + "\nQ - Return to the Main Menu"
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
            case "F":
                this.saveInventory();
                break;
            case "I":
                this.clueView();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                                  "Please enter a valid selection.");
                break;
        }
        return false;
    }
    
    private void clueView() {
        ClueView clueView = new ClueView();
        clueView.showClues();
    }
    private void castLine() {
        FishingView fishView = new FishingView();
        fishView.castLine();
    }
    private void viewMap() {
        MapView mapView = new MapView();
        mapView.display();
    }
    private void lookAround() {
        AreaView areaView = new AreaView();
        areaView.viewArea();
    }
    private void checkBoat() {
        Game game = FishingChampion.getCurrentGame();
        Player player = game.getPlayer();
        InventoryItem[] inventory = game.getInventoryItem();
        this.console.println(player.getName());
        this.console.println("Money = " + inventory[Game.Item.money.ordinal()].getAmount());
        this.console.println("Fuel = " + inventory[Game.Item.fuel.ordinal()].getAmount());
        this.console.println("Fish = " + inventory[Game.Item.fish.ordinal()].getAmount());
        this.console.println("Bait = " + inventory[Game.Item.bait.ordinal()].getAmount() + "/" + inventory[Game.Item.bait.ordinal()].getMaxAmout());
        this.console.println("Fuel Efficiency = " + inventory[Game.Item.fuelEfficiency.ordinal()].getAmount());
        this.console.println("Maximum Weight = " + inventory[Game.Item.maxWeight.ordinal()].getAmount());
    }

    private void saveInventory() {
        this.console.println("\n\nEnter the file path for the file where the inventory "
                           + "is to be saved.");
        String filePath = this.getInput();
        try {
            GameControl.writeInventory(FishingChampion.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }
}
