package byui.cit260.fishingChampion.model;

/*
 * Created by brax10 on 5/13/17.
 */
public class Location {

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public Location() {}

    private int row;
    private int column;
    private boolean visited;
    private Scene scene;
    private Shop shop;
    private Actor actor;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public int getRow() { return row; }

    public void setRow( int row ) { this.row = row;}

    public int getColumn() { return column; }

    public void setColumn( int column ) { this.column = column; }
    
    public boolean getVisited() {
        return visited;
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
