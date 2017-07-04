/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Keith Downing
 */
public class FishingControlException extends Exception {

    public FishingControlException() {
    }

    public FishingControlException(String string) {
        super(string);
    }

    public FishingControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public FishingControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public FishingControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
        
   
    
}
