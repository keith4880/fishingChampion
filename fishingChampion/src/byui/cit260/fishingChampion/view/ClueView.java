/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.control.ClueControl;
import byui.cit260.fishingChampion.model.Game;
import fishingchampion.FishingChampion;

/**
 *
 * @author Keith Downing
 */
public class ClueView extends View{

    public ClueView(){
        super("\nQ to quit");
        
    }

    /**
     *
     * @param choice
     * @return
     */
    @Override
    public boolean doAction(String choice) {
            return false;
       
}

    void showClues() {
        String[] clues = ClueControl.getClues();
        boolean notNull = false;
        for (String clue : clues) {
            if (clue == null) {
            } else {
                System.out.println(clue);
                notNull = true;
            }
        }
        if (!notNull) {
            System.out.println("You haven't found any clues.");
        } else {
                    this.display();
        }
    }

    
    

    
}

