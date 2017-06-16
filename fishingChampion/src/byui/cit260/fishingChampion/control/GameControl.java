/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Boat;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.TackleBox;
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
        Game game = new Game();
        game.setPlayer(player);
        TackleBox tackleBox = new TackleBox();
        game.setTackleBox(tackleBox);
        Boat boat = new Boat();
        game.setBoat(boat);
        Map map = MapControl.createMap();
        game.setMap(map);
        FishingChampion.setCurrentGame(game);
        return game;
    }


    
}
