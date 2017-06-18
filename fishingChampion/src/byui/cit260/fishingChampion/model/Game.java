package byui.cit260.fishingChampion.model;


/*
 * Created by brax10 on 5/13/17.
 */
public class Game {
    private String totalTime;
    private Player player;
    private InventoryItem[] inventory;
    private Map map;
    public enum Item {
        money,
        fish,
        fuel,
        bait,
        maxWeight,
        fuelEfficiency;
    }
    
    public Game() {
    }
    
    public InventoryItem[] getInventoryItem() {
            return inventory;
    }   
    
    public void setInventoryItem(InventoryItem[] inventory) {
        this.inventory = inventory;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Map getMap() {
        return map;
    }
    
    public void setMap(Map map) {
        this.map = map;
    }
    
    public String getTotaltime() { return totalTime; }

    public void setTotalTime(String totalTime) { this.totalTime = totalTime; }
}
