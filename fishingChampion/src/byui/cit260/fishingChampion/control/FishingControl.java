/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Boat;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.TackleBox;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class FishingControl {



  
 
    public static int generateFish() {
        int fishWeight;
        fishWeight = (int) Math.round(Math.random() * 50 + 1);
                return fishWeight;
    }
    public static int determineCatch(int fishWeight, int pullStrength) {
        int isCaught;
        if (pullStrength < 0) {
            isCaught = -1;
        } else if (pullStrength > 100) {
            isCaught = 101;
        } else if (pullStrength == 0) {
            isCaught = 0;
        } else if (Math.abs(fishWeight - pullStrength) > 5) {
            isCaught = 2;
        } else {
            isCaught = 1;
        }
        return isCaught;
    }

    public static void addFish(int fishWeight) {
        Game game = FishingChampion.getCurrentGame();
        Boat boat = game.getBoat();
        boat.setFishContained(boat.getFishContained() + fishWeight);
    }

    public static void subtractBait() {
        Game game = FishingChampion.getCurrentGame();
        TackleBox tackleBox = game.getTackleBox();
        tackleBox.setAmountContained(tackleBox.getAmountContained()-1);
    }
    
    /*
     *
     * @param fuelContained
     * @param fishContained
     * @return 
     */
    public static boolean calcBoatSink() {
        Game game = FishingChampion.getCurrentGame();
        Boat boat = game.getBoat();
        int maxWeight = boat.getMaxWeight();
        int fuelContained = boat.getFuelContained();
        int fishContained = boat.getFishContained();
        int weight = maxWeight - (fuelContained + fishContained);
        if (weight < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void sinkBoat() {
        System.out.println("\nsinkBoat function called");
    }

}
    
/*
FOR LOOP EXAMPLE:

for(count = 0; count < 5; count +1)

This for loop will iterate itself before termination a total of 5 times. The
beginning value is 0 and will continue to add 1 until the value reaches 5 
due to conditions within that statement.



*/
