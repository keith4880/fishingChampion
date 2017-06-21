/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.model.Game;
import fishingchampion.FishingChampion;

/**
 *
 * @author Keith Downing
 */
public class ClueView extends View{

    public ClueView(){
        super("\n-----------------------------------"
            + "\n"
            + "\n==================================="
            + "\n| Clues Menu                      |"
            + "\n==================================="
            + "\n1 - Clue 1"
            + "\n2 - Clue 2"
            + "\n3 - Clue 3"
            + "\n4 - Clue 4"
            + "\n5 - Clue 5"
            + "\nQ - Quit"
            + "\n================================== ");
        
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
                default:
                    System.out.println("\n*** Invalid selection *** Try Again");
                    break;
                
            }
            return false;
       
}

    private void clue1() {
        Game game = FishingChampion.getCurrentGame();
        String[] clues = game.getClues();
        System.out.println(clues[0]); 
    }

    private void clue2() {
        Game game = FishingChampion.getCurrentGame();
        String[] clues = game.getClues();
        System.out.println(clues[1]); 
    }

    private void clue3() {
        Game game = FishingChampion.getCurrentGame();
        String[] clues = game.getClues();
        System.out.println(clues[2]); 
    }

    private void clue4() {
        Game game = FishingChampion.getCurrentGame();
        String[] clues = game.getClues();
        System.out.println(clues[3]); 
    }

    private void clue5() {
        Game game = FishingChampion.getCurrentGame();
        String[] clues = game.getClues();
        System.out.println(clues[4]);  
    }

    
    

    
}

