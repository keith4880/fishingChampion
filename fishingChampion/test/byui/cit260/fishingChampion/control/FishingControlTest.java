/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kyt09
 */
public class FishingControlTest {
    
    public FishingControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generateFish method, of class FishingControl.
     */
    @Test
    public void testGenerateFish() {
        System.out.println("generateFish");
        FishingControl instance = new FishingControl();
        int expResult = 0;
        int result = instance.generateFish();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
