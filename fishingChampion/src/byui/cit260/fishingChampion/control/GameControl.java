/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class GameControl {

    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        player.setMoneyAmount(100);
        FishingChampion.setPlayer(player);
        return player;
    }
    public static Game createNewGame(Player player) {
        Game game = new Game(player);
        FishingChampion.setCurrentGame(game);
        return game;
    }


    
}
