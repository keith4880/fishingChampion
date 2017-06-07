/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;
import byui.cit260.fishingChampion.control.MapControl;
import java.util.Scanner;

/*
 *
 * @author Keith Downing
 */
public class MapView {

    public void viewMap() {
        
        boolean done = false;
        do {
            String mapOption = this.getMapOption();
            if (mapOption.toUpperCase().equals("X")) {
                return;
            } else {
            }
            
           
        }
        while (!done);
    }

    private String getMapOption() {
        System.out.println("\n*** getMapOption() function called ***");
        return null;
   
    }

 
    public int doAction(String mapOption) {
        int choice = 0;
        switch (choice) {
            case 'N': //new map
                this.startNewMap();
                break;
            case 'R': // new row
                this.startNewRow();
                break;
            case 'C': //new column
                this.startNewColumn();
                break;
            case 'Q': //quit
                return choice;
            default:
                System.out.println("\n*** Invalid selection *** Try Again");
                break;
        }
        return 0;
    }
    
    public String getInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;
        
        while (!valid) {
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) {
                System.out.println("\n*** Invalid selection *** Tray Again");
                continue;
                
            }
            break;
        }
    
    return selection;
    }

    private void startNewMap() {
        // new map
        int value = MapControl.createNewMap();
        if (value < 0){
            System.out.println("ERROR - Failed to Create New Map");
        }
    
        // Display the map menu
        MapView mapMenu = new MapView();
        mapMenu.displayMenu();
    }

    private void startNewRow() {
        System.out.println("*** startRow function called ***");
    }

    private void startNewColumn() {
        System.out.println("*** startColumn function called ***");
    }

    private void displayMenu() {
        System.out.println("*** startColumn function called ***");
    }

    
}
    

        



