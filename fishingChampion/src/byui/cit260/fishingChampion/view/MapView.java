/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.LocationControl;
import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Location;
import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.model.Scene;
import exceptions.LocationControlException;
import exceptions.MapControlException;
import fishingchampion.FishingChampion;

/*
 *
 * @author Keith Downing
 */
public class MapView extends View {

    public MapView() {
        super("\nEnter the row/column you would like to travel to."
                + "\nQ to quit");
        this.viewMap();
    }

    public void viewMap() {
        Game game = FishingChampion.getCurrentGame();
        Map map = game.getMap();
        Player player = game.getPlayer();
        Location[][] locations = map.getLocations();
        String dashes = "-";
        String numbers = "   ";
        for (int i = 0; i < locations[0].length; i++) {
            dashes = dashes.concat("------");
            numbers = numbers.concat((i + 1) + "     ");
        }
        this.console.println("\n" + numbers);
        for (int i = 0; i < locations.length; i++) {
            this.console.println("\n" + dashes);
            this.console.print(i + 1);
            for (int j = 0; j < locations[i].length; j++) {
                this.console.print("|");
                if (player.getRow() == i && player.getColumn() == j) {
                    Scene scene = locations[i][j].getScene();
                    if (scene == null) {
                        this.console.print("*??*");
                    } else {
                        this.console.print("*" + scene.getDisplaySymbol() + "*");
                    }
                } else {
                    if (locations[i][j].getVisited() == true) {
                        Scene scene = locations[i][j].getScene();
                        if (scene == null) {
                            this.console.print(" ?? ");
                        } else {
                            this.console.print(">" + scene.getDisplaySymbol() + "<");
                        }
                    } else {
                        Scene scene = locations[i][j].getScene();
                        if (scene == null) {
                            this.console.print(" ?? ");
                        } else {
                            this.console.print(" " + scene.getDisplaySymbol() + " ");
                        }
                    }
                }
                this.console.print("|");
            }
        }
        this.console.println("\n" + dashes);
    }

    @Override
    public boolean doAction(String value) {
        int row = -1;
        int column = -1;
        try {
            row = Integer.parseInt(value.substring(0, 1)) - 1;
        } catch (NumberFormatException nFE) {
            ErrorView.display(this.getClass().getName(),
                    "Please enter a valid selection." + nFE.getMessage());
        }
        try {
            column = Integer.parseInt(value.substring(value.length() - 1, value.length())) - 1;
        } catch (NumberFormatException nFE) {
            ErrorView.display(this.getClass().getName(),
                    "Please enter a valid selection." + nFE.getMessage());
            return false;
        }
        boolean valid = true;
        try {
            LocationControl.checkValid(row, column);
        } catch (MapControlException me) {
            ErrorView.display(this.getClass().getName(),
                    me.getMessage());
            valid = false;
        }
        if (valid) {
            double distance = LocationControl.determineDistance(row, column);

            try {
                int fuel = LocationControl.calcFuelNeeded(distance);
                MoveView moveView = new MoveView(row, column, fuel);
                moveView.display();
            } catch (LocationControlException lce) {
                ErrorView.display(this.getClass().getName(),
                    lce.getMessage());
            }
        }
        return false;
    }
}
