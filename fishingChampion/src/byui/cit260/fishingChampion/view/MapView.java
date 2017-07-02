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
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author Keith Downing
 */
public class MapView extends View {

    public MapView() {
        super("\nEnter the row/column you would like to travel to."
                + "\nQ to quit");
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
        System.out.println("\n" + numbers);
        for (int i = 0; i < locations.length; i++) {
            System.out.println("\n" + dashes);
            System.out.print(i + 1);
            for (int j = 0; j < locations[i].length; j++) {
                System.out.print("|");
                if (player.getRow() == i && player.getColumn() == j) {
                    Scene scene = locations[i][j].getScene();
                    if (scene == null) {
                        System.out.print("*??*");
                    } else {
                        System.out.print("*" + scene.getDisplaySymbol() + "*");
                    }
                } else {
                    if (locations[i][j].getVisited() == true) {
                        Scene scene = locations[i][j].getScene();
                        if (scene == null) {
                            System.out.print(" ?? ");
                        } else {
                            System.out.print(">" + scene.getDisplaySymbol() + "<");
                        }
                    } else {
                        Scene scene = locations[i][j].getScene();
                        if (scene == null) {
                            System.out.print(" ?? ");
                        } else {
                            System.out.print(" " + scene.getDisplaySymbol() + " ");
                        }
                    }
                }
                System.out.print("|");
            }
        }
        System.out.println("\n" + dashes);
    }

    @Override
    public boolean doAction(String value) {
        int row;
        int column;
        try {
            row = Integer.parseInt(value.substring(0, 1)) - 1;
        } catch (NumberFormatException nFE) {
            System.out.println("Please enter a valid selection.");
            return false;
        }
        try {
            column = Integer.parseInt(value.substring(value.length() - 1, value.length())) - 1;
        } catch (NumberFormatException nFE) {
            System.out.println("Please enter a valid selection.");
            return false;
        }
        boolean valid = true;
        try {
            LocationControl.checkValid(row, column);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
            valid = false;
        }
        if (valid) {
            double distance = LocationControl.determineDistance(row, column);

            try {
                int fuel = LocationControl.calcFuelNeeded(distance);
                System.out.println("\nMoving to " + (row + 1) + "/" + (column + 1) + " will require " + fuel + " fuel."
                        + "\nY to proceed, Q to quit");
                String confirm = this.Confirm().toUpperCase();
                switch (confirm) {
                    case "Y":
                        LocationControl.movePlayer(row, column, fuel);
                        System.out.println("\nBoat moved.");
                        return true;
                    case "Q":
                        return true;
                    default:
                        System.out.println("\nInvalid selection.");
                        return false;
                }
            } catch (LocationControlException lce) {
                System.out.println(lce.getMessage());
            }
        }
        return false;
    }

    private String Confirm() {
        String value = "";
        try {
            value = this.keyboard.readLine();
        } catch (IOException ex) {
            System.out.println("Error reading input.");
        }
        value = value.trim();
        return value;
    }
}
