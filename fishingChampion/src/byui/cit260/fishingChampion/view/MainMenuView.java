/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.GameControl;
import fishingchampion.FishingChampion;
import java.util.Scanner;

/**
 *
 * @author kyt09
 */
public class MainMenuView {
    private String menu;
    public MainMenuView() {
            this.menu = "\n"
                      + "\n----------------------------------------"
                      + "\n| Main Menu                            |"
                      + "\n----------------------------------------"
                      + "\nN - New Game"
                      + "\nL - Load Game"
                      + "\nS - Save Game"
                      + "\nH - Get help on how to play"
                      + "\nQ - Quit Game"
                      + "\n----------------------------------------";
    }
    public void displayMainMenuView() {
        boolean done = false;
        System.out.println(menu);
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))
                return;
            done = this.doAction(menuOption);
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("\nSelect a menu option using the keyboard.");
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

    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "N":
                this.startNewGame();
                System.out.println(menu);
                break;
            case "L":
                this.loadGame();
                System.out.println(menu);
                break;
            case "S":
                this.saveGame();
                System.out.println(menu);
                break;
            case "H":
                this.displayHelpMenu();
                System.out.println(menu);
                break;
            default:
                System.out.println("\n*** Please enter a valid selection.");
                System.out.println(menu);
                break;
        }
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(FishingChampion.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayGameMenuView();
    }

    private void loadGame() {
        System.out.println("*** loadGame function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.displayHelpMenuView();
    }
    
}
