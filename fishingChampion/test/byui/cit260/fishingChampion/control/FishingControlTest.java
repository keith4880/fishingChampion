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

    /*
     * Test of calcBoatSink method, of class FishingControl.
     */
    @Test
    public void testCalcBoatSink() {
        System.out.println("calcBoatSink Test 1");
        double fuelContained = 100.0;
        double fishContained = 100.0;
        FishingControl instance = new FishingControl();
        
        double expResult = 0.0;
        double result = instance.calcBoatSink(fuelContained, fishContained);
        assertEquals(expResult, result, 100.0);
      
        
        // Test Case #2
        System.out.println("calcBoatSink Test 2");
        fuelContained = 101.0;
        fishContained = 101.0;
        
        expResult = -1;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
        
        // Test Case #3
        System.out.println("calcBoatSink Test 3");
        fuelContained = 101.0;
        fishContained = 100.0;
        
        expResult = -1.0;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
        
        // Test Case #4
        System.out.println("calcBoatSink Test 4");
        fuelContained = 100.0;
        fishContained = 101.0;
        
        expResult = -1.0;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
        
        // Test Case #5
        System.out.println("calcBoatSink Test 5");
        fuelContained = 100.0;
        fishContained = 99.0;
        
        expResult = 1.0;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
        
        // Test Case #6
        System.out.println("calcBoatSink Test 6");
        fuelContained = 99.0;
        fishContained = 100.0;
        
        expResult = 1.0;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
        
        // Test Case #7
        System.out.println("calcBoatSink Test 7");
        fuelContained = 50.0;
        fishContained = 100.0;
        
        expResult = 50.0;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
        
        // Test Case #8
        System.out.println("calcBoatSink Test 8");
        fuelContained = 100.0;
        fishContained = 50.0;
        
        expResult = 50.0;
        
        result = instance.calcBoatSink(fuelContained, fishContained);
        
        assertEquals(expResult, result, 100);
    }
    
}
