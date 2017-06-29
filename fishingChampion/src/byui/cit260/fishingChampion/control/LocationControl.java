





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
import exceptions.MapControlException;
import exceptions.LocationControlException;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class LocationControl {

    public static void checkValid(int row, int column) throws MapControlException {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        int rowCount = locations.length;
        int columnCount = locations[0].length;
        if (row + 1 > rowCount || column + 1 > columnCount || row < 0 || column < 0) {
            throw new MapControlException("That location is outside the bounds of the map.");
        }
    }
    public static double determineDistance(int newRow, int newColumn) {
        Game game = FishingChampion.getCurrentGame();
        Player player = game.getPlayer();
        int row = player.getRow();
        int column = player.getColumn();
        double distance = Math.sqrt((Math.pow(newRow - row, 2)) + (Math.pow(newColumn - column, 2)));
        return distance;
    }
    
    public static int calcFuelNeeded(double distance) throws LocationControlException {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        int fuelEfficiency = inventory[Game.Item.fuelEfficiency.ordinal()].getAmount();
        int fuelNeeded = (int) distance / fuelEfficiency;
        int fuelContained = inventory[Game.Item.fuel.ordinal()].getAmount();
        if (fuelNeeded > fuelContained) {
            throw new LocationControlException("The boat does not have enough fuel to reach this location.");
        }
        
        return fuelNeeded;
    }

    public static void movePlayer(int row, int column, int fuel) {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        InventoryItem[] inventory = game.getInventoryItem();
        Player player = game.getPlayer();
        player.setRow(row);
        player.setColumn(column);
        inventory[Game.Item.fuel.ordinal()].setAmount(inventory[Game.Item.fuel.ordinal()].getAmount() - fuel);
        locations[row][column].setVisited(true);
    }
}
