/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Location;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.Scene;
import fishingchampion.FishingChampion;

/**
 *
 * @author Keith Downing
 */
public class ClueControl {

    public static String getClue() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        Player player = game.getPlayer();
        int fishRow = 0;
        int fishColumn = 0;
        for(int i = 0; i < locations.length; i++) {
            for(int j = 0; j < locations[i].length; j++) {
                Scene scene = locations[i][j].getScene();
                if (scene == null) {
                    
                } else {
                    if ("--".equals(scene.getDisplaySymbol())){
                        fishRow = i;
                        fishColumn = j;
                    }
                }
            }
        }
        if (fishRow < 1 || fishColumn < 1) {
            String reply = "The fish around here aren't very big, are they?";
            return reply;
        } else {
            int rowDist = fishRow - player.getRow();
            int columnDist = fishColumn - player.getColumn();
            String clue;
            if (rowDist < -2 && columnDist < -2) {
                clue = "I heard there was a really big fish to the northwest.";
            } else if (rowDist < -2 && columnDist >= -2 && columnDist <= 2) {
                clue = "I heard there was a really big fish to the north.";
            } else if (rowDist < -2 && columnDist > 2) {
                clue = "I heard there was a really big fish to the northeast.";
            } else if (rowDist >= -2 && rowDist <= 2 && columnDist < -2) {
                clue = "I heard there was a really big fish to the west.";
            } else if (rowDist >= -2 && rowDist <= 2 && columnDist >= -2 && columnDist <= 2) {
                clue = "I've seen a really big fish in the waters near here.";
            } else if (rowDist >= -2 && rowDist <= 2 && columnDist > 2) {
                clue = "I've heard there's a really big fish to the east.";
            } else if (rowDist > 2 && columnDist < -2) {
                clue = "I've heard there's a really big fish to the southwest.";
            } else if (rowDist > 2 && columnDist >= -2 && columnDist <= 2) {
                clue = "I've heard there's a really big fish to the south.";
            } else if (rowDist > 2 && columnDist > 2) {
                clue = "I've heard there's a really big fish to the southeast.";
            } else {
                clue = "I've heard there's a really big fish somewhere.";
            }
            String[] clues = game.getClues();
            int clueNum = -1;
            for (int k = 4; k > -1; k--) {
                if (clues[k] == null) {
                    clueNum = k;
                }
            }
            clues[clueNum] = ((player.getRow() + 1) + "/" + (player.getColumn() + 1) + " " + clue);
            return clue;
        }
    }
    
}
