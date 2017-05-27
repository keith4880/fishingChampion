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
        if (newRow > rowCount || newRow < 0 || newColumn > columnCount || newColumn < 0) {
            return -1;
        }
        double distance;
        distance = Math.sqrt(Math.pow(newRow-row, 2)+Math.pow(newColumn-column, 2));
        return distance;
    }
}
