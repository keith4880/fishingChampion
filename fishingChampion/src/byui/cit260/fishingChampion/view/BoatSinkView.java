/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.FishingControl;

/**
 *
 * @author kyt09
 */
public class BoatSinkView extends View {
    private boolean done;
    
    public boolean boatSink() {
        String Menu = "\n----------------------------------------"
                    + "\n|Your boat is sinking.                 |"
                    + "\n----------------------------------------"
                    + "\nI - Dump fish overboard"
                    + "\nU - Dump fuel overboard"
                    + "\nS - Head for shore"
                    + "\nQ - Quit"
                    + "\n----------------------------------------"
                    + "\nPlease select an option before it's too late.";
        System.out.println(Menu);
        this.display();
        return done;
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "I":
                this.dumpFish();
                break;
            case "U":
                this.dumpFuel();
                break;
            case "S":
                this.headForShore();
                break;
            default:
                this.sinkBoat();
                System.out.println("\nYou were too slow. Your boat sank.");
        }
        return true;
    }

    private void dumpFish() {
        FishingControl.dumpFish();
        System.out.println("\nFish dumped.");
        this.done = true;
    }

    private void dumpFuel() {
        boolean fuel = FishingControl.dumpFuel();
        if (fuel == true) {
            System.out.println("\nFuel dumped.");
            this.done = true;
        } else {
            System.out.println("\nThe fish are still too heavy. Your boat sank.");
            this.sinkBoat();
            this.done = true;
        }
    }

    private void headForShore() {
        int chance = (int) Math.round(Math.random() * 50 + 1);
        if (chance > 30) {
            FishingControl.trimFish();
            System.out.println("\nYou made it to shore and dumped your extra fish.");
            this.done = true;
        } else {
            this.sinkBoat();
            System.out.println("\nThe boat sank before you could make it to shore.");
            this.done = true;
        }
    }

    private void sinkBoat() {
        FishingControl.destroyBoat();
        this.done = true;
    }
}