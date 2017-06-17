/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import java.util.Scanner;

/**
 *
 * @author Keith Downing
 */
public class ClueView extends View{

    private final String menu;
    
    public ClueView(){
        this.menu = "\n----------------------------------------"
                      + "\n"
             + "\n=========================================="
                    + "\n| Clues Menu                      |"
                    + "\n==================================="
                    + "\n1 - Clue 1"
                    + "\n2 - Clue 2"
                    + "\n3 - Clue 3"
                    + "\n4 - Clue 4"
                    + "\n5 - Clue 5"
                    + "\nX - Exit"
                    + "\n====================================";
        
    }
    public void displayClueView() {
        boolean done = false;
        System.out.println(menu);
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X"))
                return;
            done = this.doAction(menuOption);
        } while (!done);
    }
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("\nSelect a menu option using the keyboard.");
            value = keyboard.nextLine();
            value = value.trim();
            if (value.length() < 1) {
                System.out.println("\nYou must enter a selection.");
                continue;
            }
            break;
        }
        return value;
    }
    /**
     *
     * @param choice
     * @return
     */
    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase();
            
            switch (choice) {
                case "1": //Clue 1
                    this.clue1();
                    break;
                case "2": //Clue 2
                    this.clue2();
                    break;
                case "3": //Clue 3
                    this.clue3();
                    break;
                case "4": //Clue 4
                    this.clue4();
                    break;    
                case "5": //Clue 5
                    this.clue5();
                    break;
                case "X": // Exit
                    this.exit();
                    break;
                default:
                    System.out.println("\n*** Invalid selection *** Try Again");
                    break;
                
            }
            return false;
       
}

    private void clue1() {
        System.out.println("*** viewclue1 function called ***"); 
    }

    private void clue2() {
        System.out.println("*** viewclue2 function called ***"); 
    }

    private void clue3() {
        System.out.println("*** viewclue3 function called ***"); 
    }

    private void clue4() {
        System.out.println("*** viewclue4 function called ***"); 
    }

    private void clue5() {
        System.out.println("*** viewclue5 function called ***"); 
    }
    private void exit() {
        System.out.println("*** Exit function called ***"); 
    }

    
    

    
}

