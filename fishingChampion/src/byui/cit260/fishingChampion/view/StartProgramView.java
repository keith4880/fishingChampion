/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.GameControl;
import byui.cit260.fishingChampion.model.Player;

/**
 *
 * @author kyt09
 */
public class StartProgramView extends View {
    public StartProgramView() {
        super("\n****************************************"
            + "\n*                                      *"
            + "\n* Welcome to Fishing Champion.         *"
            + "\n* This game is about fishing. Your goal*"
            + "\n* is to search the lake and collect as *"
            + "\n* many pounds of fish as you can.      *"
            + "\n*                                      *"
            + "\n****************************************"
            + "\nPlease enter your name: ");
    }

    @Override
    public boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            System.out.println("\nInvalid name: " 
                    + "The name must be longer than one character.");
            return false;
        }
        Player player = GameControl.createPlayer(playersName);
        if (player == null) {
            System.out.println("\nThere was an error creating the player.");
            return false;
        }
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\n========================================"
                          + "\n Welcome to the game, " + player.getName() + "."
                          + "\n Have fun!"
                          + "\n========================================"
                          );
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
    
}
