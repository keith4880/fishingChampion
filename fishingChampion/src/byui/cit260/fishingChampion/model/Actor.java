package byui.cit260.fishingChampion.model;

/*
 * Created by brax10 on 5/13/17.
 */
public class Actor {
    public Actor() {}

    private String name, description, coordinates;

    public String getName() { return name; }

    public void setName( String name ) { this.name = name; }

    public String getDescription() { return  description; }

    public void setDescription( String description ) { this.description = description; }

    public String getCoordinates() { return coordinates; }

    public void setCoordinates( String coordinates) { this.coordinates = coordinates; }
}
