/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.FishingControl;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.TackleBox;
import fishingchampion.FishingChampion;


/**
 *
 * @author kyt09
 */
public class FishingView extends View {
    int fishWeight;
    
    public FishingView() {
        super("\n____________________");
    }
    
    public void castLine() {
        Game game = FishingChampion.getCurrentGame();
        Player player = game.getPlayer();
        TackleBox tackleBox = game.getTackleBox();
        if (tackleBox.getAmountContained() < 1) {
            System.out.println("You're out of bait.");
        } else {
            System.out.println("You cast a line into the water.");
            this.fishWeight = FishingControl.generateFish();
            boolean fish = this.getPrompt(fishWeight);
            if (fish = false) {
                return;
            } else {
                System.out.println("\nEnter a number to indicate how hard you pull.");
                this.display();
            }
        }
    }
            
    @Override
    public boolean doAction(String input) {
        int pullStrength;
        try {
            pullStrength = Integer.parseInt(input);
        }
        catch(NumberFormatException nFE) {
            System.out.println("Please enter a valid selection.");
            return false;
        }
        int isCaught = FishingControl.determineCatch(fishWeight, pullStrength);
        switch (isCaught) {
            case -1:
                System.out.println("\nYou toss your fishing line into the water."
                                 + "\nWhy did you do that?");
                FishingControl.subtractBait();
                break;
            case 0:
                System.out.println("\nYou stand and stare at the water as the fish escapes.");
                FishingControl.subtractBait();
                break;
            case 101:
                System.out.println("\nYou pull so hard, you fall into the water."
                                 + "\nThe fish escapes as you climb back on.");
                FishingControl.subtractBait();
                break;
            case 2:
                System.out.println("\nThe fish escapes.");
                FishingControl.subtractBait();
                break;
            case 1:
                System.out.println("\nYou catch a " + fishWeight + "-pound fish.");
                FishingControl.addFish(fishWeight);
                FishingControl.subtractBait();
                boolean boatSink = FishingControl.calcBoatSink();
                if (boatSink == true) {
                    FishingControl.sinkBoat();
                }
                break;
        }
        return true;
    }


    private boolean getPrompt(int fishWeight) {
        if (fishWeight > 40) {
            System.out.println("\nYou feel a tug on the line that nearly knocks you over.");
        } else if (fishWeight > 30) {
            System.out.println("\nYou feel a strong on the line.");
        } else if (fishWeight > 20) {
            System.out.println("\nYou feel a tug on the line.");
        } else if (fishWeight > 10) {
            System.out.println("\nYou feel a weak tug on the line.");
        } else if (fishWeight > 0) {
            System.out.println("\nYou barely feel a tug on the line.");
        } else {
            System.out.println("\nNothing happens.");
            return false;
        }
        return true;
    }
}