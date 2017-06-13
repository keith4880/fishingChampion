/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Boat;
import byui.cit260.fishingChampion.model.TackleBox;

/**
 *
 * @author kyt09
 */
public class InventoryControl {
    public static Boat createBoat() {
        Boat boat = new Boat();
        return boat;
    }
    public static TackleBox createTackleBox() {
        TackleBox tackleBox = new TackleBox();
        return tackleBox;
    }
}
