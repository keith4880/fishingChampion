/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishingchampion;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.view.StartProgramView;

/**
 *
 * @author Keith Downing
 */
public class FishingChampion {
    
    private static Game currentGame = null;
    private static Player player = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        FishingChampion.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        FishingChampion.player = player;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StartProgramView startProgramView = new StartProgramView();
       try {
           startProgramView.display();
       } catch (Throwable te) {
           System.out.println(te.getMessage());
           te.printStackTrace();
           startProgramView.display();
       }
    }
    
}
