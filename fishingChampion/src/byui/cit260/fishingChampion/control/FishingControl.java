/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

/**
 *
 * @author kyt09
 */
public class FishingControl {



  
 
    public int generateFish() {
        int fishWeight;
        fishWeight = (int) Math.round(Math.random() * 50 + 1);
                return fishWeight;
    }
    public int determineCatch(int fishWeight, int pullStrength) {
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
    
    /*
     * @param fuelContained
     * @param fishContained
     * @return 
     */
    public double calcBoatSink(double fuelContained, double fishContained) {
        
    if (fuelContained > 100 || fishContained > 100) {
        return -1;
    }
    
       int maxWeight = 200;
        double boatSink = maxWeight - (fuelContained + fishContained);
       return boatSink;
    
    }

}
    
/*
FOR LOOP EXAMPLE:

for(count = 0; count < 5; count +1)

This for loop will iterate itself before termination a total of 5 times. The
beginning value is 0 and will continue to add 1 until the value reaches 5 
due to conditions within that statement.



*/
