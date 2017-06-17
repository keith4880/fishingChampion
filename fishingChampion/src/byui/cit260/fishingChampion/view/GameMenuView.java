/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.model.Boat;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.TackleBox;
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
        shopView.displayShopView();
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
        Boat boat = game.getBoat();
        TackleBox tackleBox = game.getTackleBox();
        System.out.println(player.getName());
        System.out.println("Money = " + player.getMoneyAmount());
        System.out.println("Fuel = " + boat.getFuelContained());
        System.out.println("Fish = " + boat.getFishContained());
        System.out.println("Bait = " + tackleBox.getAmountContained() + "/" + tackleBox.getMaxAmount());
        System.out.println("Fuel Efficiency = " + boat.getFuelEfficiency());
        System.out.println("Maximum Weight = " + boat.getMaxWeight());
    }
}
