/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import fishingchampion.FishingChampion;
import java.io.PrintWriter;

/**
 *
 * @author kyt09
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = FishingChampion.getOutFile();
    private static final PrintWriter logFile = FishingChampion.getLogFile();
    
    public static void display(String className, String errorMessage) {
    errorFile.println(
                "----------------------------------------"
              + "\n- ERROR - " + errorMessage
              + "\n----------------------------------------");
    logFile.println(className + " - " + errorMessage);
    }
}

