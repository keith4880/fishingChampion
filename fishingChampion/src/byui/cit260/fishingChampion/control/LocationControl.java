/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

/**
 *
 * @author kyt09
 */
public class LocationControl {
    public double determineDistance(int row, int column, int newRow, int newColumn, int rowCount, int columnCount) {
        // Row failure
        if (newRow > rowCount || newRow <= 0 || row > rowCount || row <= 0 || rowCount <= 0)  {
            return -1;
        }
        // Column failure
        if (newColumn > columnCount || newColumn <= 0 || column > columnCount || column <= 0 || columnCount <= 0) {
            return -2;
        }
        
        double distance = Math.sqrt((Math.pow(newRow - row, 2)) + (Math.pow(newColumn - column, 2)));
        
        return distance;
    }
    
    public double calcFuelNeeded(double distance, double fuelEfficiency) {
        if (distance < 0) {
            return -1;
        }
        
        if (fuelEfficiency <= 0) {
            return -2;
        }
        
        double fuelNeeded = distance / fuelEfficiency;
        
        return fuelNeeded;
    }
}
