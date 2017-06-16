package byui.cit260.fishingChampion.model;


/*
 * Created by brax10 on 5/13/17.
 */
public class Game {
    private String totalTime;
    private Player player;
    private Boat boat;
    private TackleBox tackleBox;
    private Map map;
    
    public Game() {
    }

    public Boat getBoat() {
        return boat;
    }
    
    public void setBoat(Boat boat) {
        this.boat = boat;
    }
    
    public TackleBox getTackleBox() {
        return tackleBox;
    }
    
    public void setTackleBox(TackleBox tackleBox) {
        this.tackleBox = tackleBox;
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
