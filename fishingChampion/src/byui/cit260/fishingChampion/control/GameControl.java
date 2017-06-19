/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import byui.cit260.fishingChampion.model.Location;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.Scene;
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
        FishingChampion.setPlayer(player);
        return player;
    }
    public static Game createNewGame(Player player) {
        Game game = new Game();
        game.setPlayer(player);
        InventoryItem[] inventory = InventoryControl.createInventoryList();
        game.setInventoryItem(inventory);
        Map map = MapControl.createMap();
        game.setMap(map);
        FishingChampion.setCurrentGame(game);
        return game;
    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        for (Scene scene : scenes) {
            int[] coordinates = randomLocation(locations);
            locations[coordinates[0]][coordinates[1]].setScene(scene);
        }
        
        
    }
    
    private static int[] randomLocation(Location[][] locations) {
        boolean done = false;
        int row;
        int column;
        do {
            row = (int) Math.round(Math.random() * 8 + 1);
            column = (int) Math.round(Math.random() * 8 + 1);
            if (row > 0 && row < locations.length && column > 0 && column < locations[0].length && locations[row][column].getScene() == null) {
                done = true;
            }
        } while (!done);
        int[] coordinates = {row, column};
        return coordinates;
    }

    public static void placePlayer() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Player player = game.getPlayer();
        Location[][] locations = map.getLocations();
        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length; j++) {
                Scene scene = locations[i][j].getScene();
                if (scene != null) {
                    if ("ST".equals(scene.getDisplaySymbol())) {
                        locations[i][j].setVisited(true);
                        player.setRow(i);
                        player.setColumn(j);
                    }
                }
            }
        }
    }
    
    


    
}
