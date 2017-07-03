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
                ErrorView.display(this.getClass().getName(),
                        "Please enter a valid selection.");
                break;
        }
        return false;
    }

    private void startNewGame() {
        GameControl.createNewGame(FishingChampion.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        GameControl.placePlayer();
        gameMenu.display();
    }

    private void loadGame() {
        this.console.println("\n\nEnter the file path for the file where the game "
                           + "is to be saved.");
        String filePath = this.getInput();
        try {
            GameControl.getSavedGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void saveGame() {
        this.console.println("\n\nEnter the file path for the file where the game "
                           + "is to be saved.");
        String filePath = this.getInput();
        try {
            GameControl.saveGame(FishingChampion.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
}
