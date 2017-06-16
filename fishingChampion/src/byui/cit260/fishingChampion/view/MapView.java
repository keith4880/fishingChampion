/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;
import byui.cit260.fishingChampion.control.MapControl;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Location;
import byui.cit260.fishingChampion.model.Map;
import fishingchampion.FishingChampion;
import java.util.Scanner;

/*
 *
 * @author Keith Downing
 */
public class MapView {
    private final String menu;
    public MapView() {
            this.menu = "\n"
                      + "\n----------------------------------------"
                      + "\n| Map Menu                            |"
                      + "\n----------------------------------------"
                      + "\nN - New Map"
                      + "\nR - New Row"
                      + "\nC - New Column"
                      + "\nQ - Quit"
                      + "\n----------------------------------------";
    }

    public void viewMap() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocations();
        System.out.println("\n   1     2     3     4     5     6     7     8   ");
        for(int i = 0; i < locations.length; i++) {
            System.out.println("\n-------------------------------------------------");
            System.out.print(i);
            for(int j = 0; j < locations[i].length; j++) {
                System.out.print("|");
                if (locations[i][j].getVisited() == true) {
                    System.out.print(" !! ");
                } else {
                    System.out.print(" ?? ");
                }
                System.out.print("|");
            }
        }
        System.out.println("\n-------------------------------------------------");
    }
}
    

        



