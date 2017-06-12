/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.FishingControl;
import byui.cit260.fishingChampion.model.Boat;
import byui.cit260.fishingChampion.model.Game;
import fishingchampion.FishingChampion;
import java.util.Scanner;

/**
 *
 * @author kyt09
 */
public class GameMenuView {
    private String gameMenu;
    public GameMenuView() {
        this.gameMenu = "\n----------------------------------------"
                      + "\n| Game Menu                            |"
                      + "\n----------------------------------------"
                      + "\nC - Cast a Line"
                      + "\nM - View Map"
                      + "\nL - Look Around"
                      + "\nB - Check Boat"
                      + "\nS - Enter Marina Shop"
                      + "\nQ - Return to Main Menu"
                      + "\n----------------------------------------";
    }
    public void displayGameMenuView() {
        boolean done = false;
        System.out.println(gameMenu);
        do {
            String gameOption = this.getGameOption();
            if (gameOption.toUpperCase().equals("Q")) {
                return;
            }
            done = this.doAction(gameOption);
        } while (!done);
    }

    private String getGameOption() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("\nSelect a help option using the keyboard.");
            value = keyboard.nextLine();
            value = value.trim();
            if (value.length() < 1) {
                System.out.println("\nYou must enter a selection.");
                continue;
            }
            break;
        }
        return value;
    }

    private boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "C":
                this.castLine();
                System.out.println(gameMenu);
                break;
            case "M":
                this.viewMap();
                System.out.println(gameMenu);
                break;
            case "L":
                this.lookAround();
                System.out.println(gameMenu);
                break;
            case "B":
                this.checkBoat();
                System.out.println(gameMenu);
                break;
            case "S":
                this.enterShop();
                System.out.println(gameMenu);
                break;
            default:
                System.out.println("\n*** Please enter a valid selection.");
                System.out.println(gameMenu);
                break;
        }
        return false;
    }
    
    private void enterShop() {
        ShopView shopView = new ShopView();
        shopView.displayShopView();
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
        System.out.println("\ncheckBoat function called");
        Game game = FishingChampion.getCurrentGame();
        Boat boat = game.getBoat();
        System.out.println("Fuel = " + boat.getFuelContained());
    }
}
