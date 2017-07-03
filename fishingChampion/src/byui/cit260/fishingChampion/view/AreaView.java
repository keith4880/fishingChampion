/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.ClueControl;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Location;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.Scene;
import fishingchampion.FishingChampion;

/**
 *
 * @author kyt09
 */
public class AreaView extends View {
    
    public AreaView() {
        super ("\n________________________________________");
    }
    
    public void viewArea() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        Player player = game.getPlayer();
        Scene scene = locations[player.getRow()][player.getColumn()].getScene();
        if (scene == null || "--".equals(scene.getDisplaySymbol()) || "??".equals(scene.getDisplaySymbol())) {
            this.console.println("\nThere are no shops or people in sight.");
        } else if ("SH".equals(scene.getDisplaySymbol())) {
            this.console.println(scene.getDescription());
            this.console.println("\nS to enter shop, Q to quit");
            this.doShop();
        } else if ("FI".equals(scene.getDisplaySymbol())) {
            this.console.println(scene.getDescription());
            this.console.println("\nT to talk, Q to quit");
            this.doTalk();
        } else if ("ST".equals(scene.getDisplaySymbol())) {
            this.console.println(scene.getDescription());
        }
    }
    
    private void doShop() {
        String input;
        boolean done = false;
        do {
            input = this.getInput();
            switch (input.toUpperCase()) {
                case "S":
                    ShopView shopView = new ShopView();
                    shopView.display();
                    done = true;
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    this.console.println("\nPlease enter a valid selection.");
                    break;
            }
        } while (!done);
    }

    private void doTalk() {
        String input;
        boolean done = false;
        do {
            input = this.getInput();
            switch (input.toUpperCase()) {
                case "T":
                    String clue = ClueControl.getClue();
                    this.console.println(clue);
                    done = true;
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    this.console.println("\nPlease enter a valid selection.");
                    break;
            }
        } while (!done);
    }
}
