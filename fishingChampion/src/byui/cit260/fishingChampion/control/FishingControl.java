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
import byui.cit260.fishingChampion.view.BoatSinkView;
import exceptions.FishingControlException;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class FishingControl {



  
 
    public static boolean checkBait() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        return inventory[Game.Item.bait.ordinal()].getAmount() > 0;
    }
    
    public static int generateFish() {
        Game game = FishingChampion.getCurrentGame();
        Player player = game.getPlayer();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        Scene scene = locations[player.getRow()][player.getColumn()].getScene();
        int chance = (int) Math.round(Math.random() * 50 + 1);
        if (scene == null) {
        } else if ("Champion".equals(scene.getType())) {
            if (chance > 30) {
                int fishWeight;
                fishWeight = (int) Math.round(Math.random() * 100 +101);
                return fishWeight;
            }
        } else {
            int fishWeight;
            fishWeight = (int) Math.round(Math.random() * scene.getFishMax() + 1);
            return fishWeight;
        }
        int fishWeight;
        fishWeight = (int) Math.round(Math.random() * 50 + 1);
        return fishWeight;
    }
    public static int determineCatch(int fishWeight, int pullStrength) 
            throws FishingControlException {
        int isCaught;
        if (pullStrength < 0) {
            //isCaught = -1;
            throw new FishingControlException("\nYou toss your fishing line into the water."
                                     + "\nWhy did you do that?");
        } else if (pullStrength > 100) {
            //isCaught = 101;
            throw new FishingControlException("\nYou pull so hard, you fall into the water."
                                     + "\nThe fish escapes as you climb back on.");
        } else if (pullStrength == 0) {
            //isCaught = 0;
            throw new FishingControlException("\nYou stand and stare at the water as the fish escapes.");
        } else if (Math.abs(fishWeight - pullStrength) > 5) {
            isCaught = 2;
        } else {
            isCaught = 1;
        }
        return isCaught;
    }

    public static void addFish(int fishWeight) {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        inventory[Game.Item.fish.ordinal()].setAmount(inventory[Game.Item.fish.ordinal()].getAmount() + fishWeight);
    }

    public static void subtractBait() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        inventory[Game.Item.bait.ordinal()].setAmount(inventory[Game.Item.bait.ordinal()].getAmount()-1);
    }
    
    /*
     *
     * @param fuelContained
     * @param fishContained
     * @return 
     */
    public static boolean calcBoatSink() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        int maxWeight = inventory[Game.Item.maxWeight.ordinal()].getAmount();
        int fuelContained = inventory[Game.Item.fuel.ordinal()].getAmount();
        int fishContained = inventory[Game.Item.fish.ordinal()].getAmount();
        if (maxWeight == 0) {
            return false;
        }
        int weight = maxWeight - (fuelContained + fishContained);
        return weight < 0;
    }

    public static void sinkBoat() {
        BoatSinkView boatSinkView = new BoatSinkView();
        boolean done = false;
        do {
            done = boatSinkView.boatSink();
        } while (!done);
    }

    public static void dumpFish() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        inventory[Game.Item.fish.ordinal()].setAmount(0);
    }

    public static boolean dumpFuel() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        if (inventory[Game.Item.maxWeight.ordinal()].getAmount() >= inventory[Game.Item.fish.ordinal()].getAmount()) {
            inventory[Game.Item.fuel.ordinal()].setAmount(0);
            return true;
        } else {
            return false;
        }
    }

    public static void trimFish() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        inventory[Game.Item.fish.ordinal()].setAmount(inventory[Game.Item.maxWeight.ordinal()].getAmount() - inventory[Game.Item.fuel.ordinal()].getAmount());
    }
    
    public static void destroyBoat() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        inventory[Game.Item.fish.ordinal()].setAmount(0);
        inventory[Game.Item.fuel.ordinal()].setAmount(0);
        inventory[Game.Item.maxWeight.ordinal()].setAmount(0);
    }

    public static void catchChampion(int fishWeight) {
        Game game = FishingChampion.getCurrentGame();
        String[] clues = game.getClues();
        InventoryItem[] inventory = game.getInventoryItem();
        FishingControl.moveChampion();
        inventory[Game.Item.fish.ordinal()].setAmount(inventory[Game.Item.fish.ordinal()].getAmount() + fishWeight);
        String[] emptyClues = new String[clues.length];
        game.setClues(emptyClues);
    }

    private static void moveChampion() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        Player player = game.getPlayer();
        Scene championFish = locations[player.getRow()][player.getColumn()].getScene();
        locations[player.getRow()][player.getColumn()].setScene(null);
        int[] coordinates = GameControl.randomLocation(locations);
        locations[coordinates[0]][coordinates[1]].setScene(championFish);
    }

    public static boolean checkWin() {
        Game game = FishingChampion.getCurrentGame();
        InventoryItem[] inventory = game.getInventoryItem();
        return inventory[Game.Item.fish.ordinal()].getAmount() >= 500;
    }

}
    
/*
FOR LOOP EXAMPLE:

for(count = 0; count < 5; count +1)

This for loop will iterate itself before termination a total of 5 times. The
beginning value is 0 and will continue to add 1 until the value reaches 5 
due to conditions within that statement.



*/
