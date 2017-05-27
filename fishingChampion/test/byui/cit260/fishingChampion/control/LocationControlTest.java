/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kyt09
 */
public class LocationControlTest {
    
    public LocationControlTest() {
    }

    /**
     * Test of determineDistance method, of class LocationControl.
     */
    @Test
    public void testDetermineDistance() {
        System.out.println("determineDistance");
        int row = 2;
        int column = 2;
        int newRow = 2;
        int newColumn = 4;
        int rowCount = 6;
        int columnCount = 6;
        LocationControl instance = new LocationControl();
        double expResult = Math.sqrt(8);
        double result = instance.determineDistance(row, column, newRow, newColumn, rowCount, columnCount);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
