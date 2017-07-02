/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import fishingchampion.FishingChampion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class View implements ViewInterface {

    protected String displayMessage;
    
    protected final BufferedReader keyboard = FishingChampion.getInFile();
    protected final PrintWriter console = FishingChampion.getOutFile();
    
    public View() {
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false;
        do {
            String value = this.getInput();
            if (value.toUpperCase().equals("Q"))
                return;
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {
        String value = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("\n" + this.displayMessage);
            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                System.out.println("Error reading input.");
            }
            value = value.trim();
            if (value.length() < 1) {
                System.out.println("\nYou must enter a selection.");
                continue;
            }
            break;
        }
        return value;
    }

    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
