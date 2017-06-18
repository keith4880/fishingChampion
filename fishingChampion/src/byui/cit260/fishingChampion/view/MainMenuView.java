/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.GameControl;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
            super("\n"
                + "\n----------------------------------------"
                + "\n| Main Menu                            |"
                + "\n----------------------------------------"
                + "\nN - New Game"
                + "\nL - Load Game"
                + "\nS - Save Game"
                + "\nH - Get help on how to play"
                + "\nQ - Quit Game"
                + "\n----------------------------------------"
                + "\nPlease select an option using the keyboard.");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "N":
                this.startNewGame();
                break;
            case "L":
                this.loadGame();
                break;
            case "S":
                this.saveGame();
                break;
            case "H":
                this.displayHelpMenu();
                break;
            default:
                System.out.println("\n*** Please enter a valid selection.");
                break;
        }
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(FishingChampion.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void loadGame() {
        System.out.println("*** loadGame function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
}
