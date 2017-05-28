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
public class FishingControlTest {
    
    public FishingControlTest() {
    }

    /**
     * Test of generateFish method, of class FishingControl.
     */
    @Test
    public void testGenerateFish() {
        System.out.println("generateFish");
        FishingControl instance = new FishingControl();
        int result = instance.generateFish();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of determineCatch method, of class FishingControl.
     */
    @Test
    public void testDetermineCatch() {
        System.out.println("determineCatch");
        int fishWeight = 1;
        int pullStrength = -3;
        int expResult = -1;
        FishingControl instance = new FishingControl();
        int result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of calcBoatSink method, of class FishingControl.
     */
    @Test
    public void testCalcBoatSink() {
        System.out.println("calcBoatSink");
        double fuelContained = 10.0;
        double fishContained = 50.0;
        FishingControl instance = new FishingControl();
        
        double expResult = 140;
        double result = instance.calcBoatSink(fuelContained, fishContained);
        assertEquals(expResult, result, 100.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
