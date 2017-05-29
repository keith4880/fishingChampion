/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author kyt09
 */
public class LocationControlTest {
    
    public LocationControlTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of determineDistance method, of class LocationControl.
     */
    @Test
    public void testDetermineDistance() {
        System.out.println("determineDistance tests");
        LocationControl instance = new LocationControl();
        assertEquals(Math.sqrt(8), instance.determineDistance(2, 2, 4, 4, 6, 6), 0.0);
        assertEquals(-1, instance.determineDistance(7, 2, 4, 4, 6, 6), 0.0);
        assertEquals(-1, instance.determineDistance(-1, 2, 4, 4, 6, 6), 0.0);
        assertEquals(-1, instance.determineDistance(2, 2, 7, 4, 6, 6), 0.0);
        assertEquals(-1, instance.determineDistance(2, 2, -1, 4, 6, 6), 0.0);
        assertEquals(-2, instance.determineDistance(2, 2, 4, 7, 6, 6), 0.0);
        assertEquals(-2, instance.determineDistance(2, 2, 4, -1, 6, 6), 0.0);
        assertEquals(-2, instance.determineDistance(2, 7, 4, 4, 6, 6), 0.0);
        assertEquals(-2, instance.determineDistance(2, -1, 4, 4, 6, 6), 0.0);
    }

    /**
     * Test of calcFuelNeeded method, of class LocationControl.
     */
    @Test
    public void testCalcFuelNeeded() {
        System.out.println("calcFuelNeeded tests");
        LocationControl instance = new LocationControl();
        assertEquals(-2, instance.calcFuelNeeded(20, 0), 0.0);
        assertEquals(-1, instance.calcFuelNeeded(-1, 7), 0.0);
        assertEquals(10, instance.calcFuelNeeded(50, 5), 0.0);
        assertEquals(-2, instance.calcFuelNeeded(25, -1), 0.0);
        assertEquals(0, instance.calcFuelNeeded(0, 5), 0.0);
    }    
}
