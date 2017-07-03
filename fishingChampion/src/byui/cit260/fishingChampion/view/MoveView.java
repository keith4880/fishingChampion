/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.LocationControl;

/**
 *
 * @author kyt09
 */
public class MoveView extends View {
    private int row;
    private int column;
    private int fuelNeeded;
    public MoveView(int row, int column, int fuelNeeded) {
        super("\nMoving to " + (row + 1) + "/" + (column + 1) + " will require " + fuelNeeded + " fuel."
            + "\nY to proceed, Q to quit.");
        this.row = row;
        this.column = column;
        this.fuelNeeded = fuelNeeded;
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "Y":
                LocationControl.movePlayer(this.row, this.column, this.fuelNeeded);
                MapView mapView = new MapView();
                return true;
            default:
                ErrorView.display(this.getClass().getName(),
                        "Please enter a valid selection.");
                break;
        }
        return false;
    }
}
