/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.FishingControl;
import exceptions.FishingControlException;

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
        boolean checkBait = FishingControl.checkBait();
        if (checkBait == false) {
            this.console.println("You're out of bait.");
        } else {
            this.console.println("You cast a line into the water.");
            this.fishWeight = FishingControl.generateFish();
            boolean fish = this.getPrompt(fishWeight);
            if (fish == false) {
                return;
            } else {
                this.console.println("\nEnter a number to indicate how hard you pull.");
                this.display();
            }
        }
    }

    @Override
    public boolean doAction(String input) {
        int pullStrength;
        try {
            pullStrength = Integer.parseInt(input);
        } catch (NumberFormatException nFE) {
            ErrorView.display(this.getClass().getName(),
                    "Please enter a valid selection.");
            return false;
        }
        if (fishWeight > 99) {
            if (pullStrength < 100) {
                this.console.println("The fish escapes.");
                return true;
            } else {
                FishingControl.catchChampion(fishWeight);
                FishingControl.subtractBait();
                this.console.println("You caught a " + fishWeight + "-pound fish!");
                boolean boatSink = FishingControl.calcBoatSink();
                if (boatSink == true) {
                    FishingControl.sinkBoat();
                }
                return true;
            }
        } else {
            try {
                int isCaught = FishingControl.determineCatch(fishWeight, pullStrength);
                switch (isCaught) {

                    case 2:
                        this.console.println("\nThe fish escapes.");
                        FishingControl.subtractBait();
                        break;
                    case 1:
                        this.console.println("\nYou catch a " + fishWeight + "-pound fish.");
                        FishingControl.addFish(fishWeight);
                        FishingControl.subtractBait();
                        boolean boatSink = FishingControl.calcBoatSink();
                        if (boatSink == true) {
                            FishingControl.sinkBoat();
                        }
                        break;
                }

            } catch (FishingControlException fce) {
                this.console.println(fce.getMessage());
                FishingControl.subtractBait();
            }
        }
        return true;
    }

    private boolean getPrompt(int fishWeight) {
        if (fishWeight > 100) {
            this.console.println("\nYou barely feel a tug on the line.");
        } else if (fishWeight > 50) {
            this.console.println("\nYour boat nearly flips over from the force of the tug.");
        } else if (fishWeight > 40) {
            this.console.println("\nYou feel a tug on the line that nearly knocks you over.");
        } else if (fishWeight > 30) {
            this.console.println("\nYou feel a strong tug on the line.");
        } else if (fishWeight > 20) {
            this.console.println("\nYou feel a tug on the line.");
        } else if (fishWeight > 10) {
            this.console.println("\nYou feel a weak tug on the line.");
        } else if (fishWeight > 0) {
            this.console.println("\nYou barely feel a tug on the line.");
        } else {
            this.console.println("\nNothing happens.");
            return false;
        }
        return true;
    }
}
