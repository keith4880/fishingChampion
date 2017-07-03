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
            this.console.println("\n" + this.displayMessage);
            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                        "Error reading input: " + ex.getMessage());
            }
            value = value.trim();
            if (value.length() < 1) {
                ErrorView.display(this.getClass().getName(),
                        "You must enter a selection.");
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
