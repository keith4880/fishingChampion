package byui.cit260.fishingChampion.model;

import byui.cit260.fishingChampion.control.InventoryControl;

/*
 * Created by brax10 on 5/13/17.
 */
public class Game {
    private String totalTime;
    private Player player;
    private Boat boat;
    
    public Game() {
        boat = InventoryControl.createBoat();
    }
    
    public Game(Player player) {
        boat = InventoryControl.createBoat();
        this.player = player;
    }

    public Boat getBoat() {
        return boat;
    }
    
    

    public String getTotaltime() { return totalTime; }

    public void setTotalTime(String totalTime) { this.totalTime = totalTime; }
}
