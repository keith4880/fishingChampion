/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

/**
 *
 * @author kyt09
 */
public class WinView extends View {
    
    public WinView() {
        super("\n****************************************"
            + "\n*                                      *"
            + "\n* Congratulations!                     *"
            + "\n* You caught 500 pounds of fish and won*"
            + "\n* the game!                            *"
            + "\n*                                      *"
            + "\n****************************************"
            + "\nQ to return to game");
    }
    
    @Override
    public boolean doAction(String value) {
        ErrorView.display(this.getClass().getName(),
                "Please enter a valid selection.");
        return false;
    }
}
