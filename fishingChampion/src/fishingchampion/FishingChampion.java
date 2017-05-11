/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishingchampion;

import byui.cit260.fishingChampion.model.Player;

/**
 *
 * @author Keith Downing
 */
public class FishingChampion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Player playerOne = new Player();
        
        playerOne.setName("Fred Flintstone");
        playerOne.setBestTime(7.00);
        playerOne.setMoneyAmount(75.00);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
