/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.model;

import java.io.Serializable;

/**
 *
 * @author Keith Downing
 */
public class Map implements Serializable {
    //class instance variables.
    private int rowCount;
    private int columnCount;
    private Location[][] locations;
    private int currentRow;
    private int currentColumn;
    private double currentScene;
    public enum SceneType {
        start,
        championFish,
        shop1,
        shop2,
        shop3,
        shop4,
        shop5;
    }

    public Map(int noOfRows, int noOfColumns) {
        if (noOfRows < 1 || noOfColumns < 1) {
            System.out.println("The number of rows and columns must be more than zero.");
            return;
        }
        rowCount = noOfRows;
        columnCount = noOfColumns;
        this.locations = new Location[noOfRows][noOfColumns];
        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setVisited(false);
                locations[row][column] = location;
            }
        }
        
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public double getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(double currentScene) {
        this.currentScene = currentScene;
    }
    
    public Location[][] getLocations() {
        return locations;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.rowCount) ^ (Double.doubleToLongBits(this.rowCount) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.columnCount) ^ (Double.doubleToLongBits(this.columnCount) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.currentRow) ^ (Double.doubleToLongBits(this.currentRow) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.currentColumn) ^ (Double.doubleToLongBits(this.currentColumn) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.currentScene) ^ (Double.doubleToLongBits(this.currentScene) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", currentRow=" + currentRow + ", currentColumn=" + currentColumn + ", currentScene=" + currentScene + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        if (Double.doubleToLongBits(this.rowCount) != Double.doubleToLongBits(other.rowCount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.columnCount) != Double.doubleToLongBits(other.columnCount)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentRow) != Double.doubleToLongBits(other.currentRow)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentColumn) != Double.doubleToLongBits(other.currentColumn)) {
            return false;
        }
        if (Double.doubleToLongBits(this.currentScene) != Double.doubleToLongBits(other.currentScene)) {
            return false;
        }
        return true;
    }
    
    public Map() {
    }
    
    
    
}
