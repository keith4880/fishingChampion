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
        super(
"\n***************************************************************"
+ "\n*                                                             *"
+ "\n*                    XXXXXXXXXXXXXXXX                         *"
+ "\n*                 XXXXXXXXXXXXXXXXXXXXXXXXX             XX    *"
+ "\n*               XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX        XXX    *"
+ "\n*              XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*            XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*           XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*         XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*          XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*            XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*              XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX    *"
+ "\n*               XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX         XXX    *"
+ "\n*                  XXXXXXXXXXXXXXXXXXXXXXX              XX    *"
+ "\n*                    XXXXXXXXXXXXXXXX                         *"
+ "\n*                                                             *"					
+ "\n***************************************************************"	
+ "\n*                                                             *"			
+ "\n*              WELCOME TO FISHING CHAMPION                    *"
+ "\n*                                                             *"
+ "\n* This game is about fishing. Your goal is to search the lake *"
+ "\n* and collect 500 pounds of fish.                             *"
+ "\n*                                                             *"
+ "\n* Let the fishing adventure begin.                            *"
+ "\n*                                                             *"
+ "\n* Good luck angler and have fun!                              *"
+ "\n*                                                             *"
+ "\n***************************************************************"
+ "\n                                                               "
+ "\n Please Enter Your Name: ");					
    }

    @Override
    public boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            ErrorView.display(this.getClass().getName(),
                    "\nInvalid name: " 
                    + "The name must be longer than one character.");
            return false;
        }
        Player player = GameControl.createPlayer(playersName);
        if (player == null) {
            ErrorView.display(this.getClass().getName(),
                    "Error creating player.");
            return false;
        }
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        this.console.println("\n========================================"
                          + "\n Welcome to the game, " + player.getName() + "."
                          + "\n Have fun!"
                          + "\n========================================"
                          );
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
    
}
