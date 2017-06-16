package byui.cit260.fishingChampion.model;

import java.util.ArrayList;

/*
 * Created by brax10 on 5/13/17.
 */
public class Location {
    public Location() {}

    private int row;
    private int column;
    private boolean visited;
    private Scene scene;
    private ArrayList<Actor> actors;

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
