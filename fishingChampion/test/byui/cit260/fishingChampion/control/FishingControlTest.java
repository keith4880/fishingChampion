/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import exceptions.FishingControlException;
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
    public void testDetermineCatch() throws FishingControlException {
        // Successful catch
        System.out.println("determineCatch test 1");
        int fishWeight = 10;
        int pullStrength = 10;
        int expResult = 1;
        FishingControl instance = new FishingControl();
        int result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        
        // Failure to catch
        System.out.println("determineCatch test 2");
        fishWeight = 10;
        pullStrength = 16;
        expResult = 2;
        result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        
        // Negative error
        System.out.println("determineCatch test 3");
        fishWeight = 10;
        pullStrength = -10;
        expResult = -1;
        result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        
        // Zero error
        System.out.println("determineCatch test 4");
        fishWeight = 10;
        pullStrength = 0;
        expResult = 0;
        result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        
        // Too big error
        System.out.println("determineCatch test 5");
        fishWeight = 10;
        pullStrength = 105;
        expResult = 101;
        result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        
        // Border successful catch
        System.out.println("determineCatch test 6");
        fishWeight = 10;
        pullStrength = 15;
        expResult = 1;
        result = instance.determineCatch(fishWeight, pullStrength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
}
