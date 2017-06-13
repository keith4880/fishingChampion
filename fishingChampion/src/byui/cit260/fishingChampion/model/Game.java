package byui.cit260.fishingChampion.model;

import byui.cit260.fishingChampion.control.InventoryControl;

/*
 * Created by brax10 on 5/13/17.
 */
public class Game {
    private String totalTime;
    private Player player;
    private Boat boat;
    private TackleBox tackleBox;
    
    public Game() {
        boat = InventoryControl.createBoat();
        tackleBox = InventoryControl.createTackleBox();
    }
    
    public Game(Player player) {
        boat = InventoryControl.createBoat();
        tackleBox = InventoryControl.createTackleBox();
        this.player = player;
    }

    public Boat getBoat() {
        return boat;
    }
    
    public TackleBox getTackleBox() {
        return tackleBox;
    }
    
    

    public String getTotaltime() { return totalTime; }

    public void setTotalTime(String totalTime) { this.totalTime = totalTime; }
}
