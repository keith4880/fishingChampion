/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import java.util.Scanner;

/*
 *
 * @author Keith Downing
 */
public class MapView {

    private String promptMessage;
    

    public MapView() {
        String map = "\nX - Exit Map Menu"
                + "\n"
                + "\n=========================================="
                + "\n| Map Menu                              |"
                + "\n=========================================="
                + "\nM - Map"
                + "\nR - Row"
                + "\nC - Column"
                + "\nS - Save Game"
                + "\n==========================================";
    }
        public void displayMapMenuView(){
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X")) //user wants to quit
                return; // Exit menu
                
            // Do the requested action and display the next view
            done = this.doAction(menuOption);
                
        }while (!done);
    }
        private String getMenuOption() {
       Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is enter
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading adn trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
                continue;
        }
        break; // end the loop
        
        }
        return value;
    }
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); // convert choice to uppercase
            
            switch (choice) {
                case "M": //Creates a new map
                    this.startMap();
                    break;
                case "R": //Creates a new row
                    this.startRow();
                    break;
                case "C": //Creates a new column
                    this.startColumn();
                    break;
                case "S": // Saves game
                    this.saveGame();
                    break;
                default:
                    System.out.println("\n*** Invalid selection *** Try Again");
                    break;
                
            }
            return false;
    }

    private void startMap() {
      
    /*    // new map
        int value = MapControl.createNewMap(FindTheBone.getMap());
        if (value < 0){
            System.out.println("ERROR - Failed to Create New Map");
        }
    
        // Display the map menu
        MapMenuView mapMenu = new MapMenuView();
        mapMenu.displayMenu();
      */ 
    }

    private void startRow() {
        System.out.println("*** startRow function called ***");
    }

    private void startColumn() {
        System.out.println("*** startColumn function called ***");
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }

    void viewMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
}


