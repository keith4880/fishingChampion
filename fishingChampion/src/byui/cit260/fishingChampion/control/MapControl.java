/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Map;
import byui.cit260.fishingChampion.model.Scene;

/*
 *
 * @author Keith Downing
 */
public class MapControl {
 
    public static Map createMap() {
        //create the map
        int rows = (int) Math.round(Math.random() * 4 + 5);
        int columns = (int) Math.round(Math.random() * 4 + 5);
        Map map = new Map(rows, columns);
        Scene[] scenes = createScenes();
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[Map.SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setType("Start");
        startingScene.setDescription(
            "This is where your journey began.");
        startingScene.setDisplaySymbol("ST");
        startingScene.setFishMax(75);
        scenes[Map.SceneType.start.ordinal()] = startingScene;
        
        Scene championFishScene = new Scene();
        championFishScene.setType("Champion");
        championFishScene.setDescription(
            "There are no shops or people in sight.");
        championFishScene.setDisplaySymbol("??");
        championFishScene.setFishMax(25);
        scenes[Map.SceneType.championFish.ordinal()] = championFishScene;
        
        Scene shopScene = new Scene();
        shopScene.setType("Shop");
        shopScene.setDescription(
                "A marina shop sits on a nearby shore.");
        shopScene.setDisplaySymbol("SH");
        shopScene.setFishMax(50);
        scenes[Map.SceneType.shop1.ordinal()] = shopScene;
        scenes[Map.SceneType.shop2.ordinal()] = shopScene;
        scenes[Map.SceneType.shop3.ordinal()] = shopScene;
        scenes[Map.SceneType.shop4.ordinal()] = shopScene;
        scenes[Map.SceneType.shop5.ordinal()] = shopScene;
        
        Scene fishermanScene = new Scene();
        fishermanScene.setType("Fisherman");
        fishermanScene.setDescription(
                "A fisherman sits in a small boat nearby.");
        fishermanScene.setDisplaySymbol("FI");
        fishermanScene.setFishMax(40);
        scenes[Map.SceneType.man1.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man2.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man3.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man4.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man5.ordinal()] = fishermanScene;
        
        Scene fishScene = new Scene();
        fishScene.setType("Fish");
        fishScene.setDescription("There are no shops or people in sight.");
        fishScene.setDisplaySymbol("??");
        fishScene.setFishMax((int) Math.round(Math.random() * 75 + 25));
        scenes[Map.SceneType.fish1.ordinal()] = fishScene;
        fishScene.setFishMax((int) Math.round(Math.random() * 75 + 25));
        scenes[Map.SceneType.fish2.ordinal()] = fishScene;
        fishScene.setFishMax((int) Math.round(Math.random() * 75 + 25));
        scenes[Map.SceneType.fish3.ordinal()] = fishScene;
        fishScene.setFishMax((int) Math.round(Math.random() * 75 + 25));
        scenes[Map.SceneType.fish4.ordinal()] = fishScene;
        fishScene.setFishMax((int) Math.round(Math.random() * 75 + 25));
        scenes[Map.SceneType.fish5.ordinal()] = fishScene;
        
        return scenes;
    }
}