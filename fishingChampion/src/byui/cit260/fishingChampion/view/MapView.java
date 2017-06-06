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

    public void viewMap() {
        
        boolean done = false;
        do {
            String mapOption = this.getMapOption();
            if (mapOption.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(mapOption);
        }
        while (!done);
    }

    private String getMapOption() {
        System.out.println("\n*** getMapOption() function called ***");
        return "N";
    }

    private boolean doAction(String mapOption) {
        System.out.println("\n*** doAction() function called ***");
        return true;
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
}
    

        



