/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Location;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.Scene;
import fishingchampion.FishingChampion;

/*
 *
 * @author Keith Downing
 */
public class MapView  extends View {
    public MapView() {
    }

    public void viewMap() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Player player = game.getPlayer();
        Location[][] locations = map.getLocations();
        System.out.println("\n   1     2     3     4     5     6     7     8   ");
        for(int i = 0; i < locations.length; i++) {
            System.out.println("\n-------------------------------------------------");
            System.out.print(i);
            for(int j = 0; j < locations[i].length; j++) {
                System.out.print("|");
                if (player.getRow() == i && player.getColumn() == j) {
                    System.out.print(" PL ");
                } else {
                    if (locations[i][j].getVisited() == true) {
                        Scene scene = locations[i][j].getScene();
                        if (scene == null) {
                            System.out.print(" -- ");
                        } else {
                        System.out.print(" " + scene.getDisplaySymbol() + " ");
                        }
                    } else {
                        System.out.print(" ?? ");
                    }
                }
                System.out.print("|");
            }
        }
        System.out.println("\n-------------------------------------------------");
    }
    
    
}
    

        



