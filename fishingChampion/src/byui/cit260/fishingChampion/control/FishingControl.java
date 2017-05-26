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
    
}
