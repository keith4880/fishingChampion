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
        Map map = new Map(8, 8);
        Scene[] scenes = createScenes();
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[Map.SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription(
            "This is where your journey began.");
        startingScene.setDisplaySymbol("ST");
        scenes[Map.SceneType.start.ordinal()] = startingScene;
        
        Scene championFishScene = new Scene();
        championFishScene.setDescription(
            "There are no shops or people in sight.");
        championFishScene.setDisplaySymbol("--");
        scenes[Map.SceneType.championFish.ordinal()] = championFishScene;
        
        Scene shopScene = new Scene();
        shopScene.setDescription(
                "A marina shop sits on a nearby shore.");
        shopScene.setDisplaySymbol("SH");
        scenes[Map.SceneType.shop1.ordinal()] = shopScene;
        scenes[Map.SceneType.shop2.ordinal()] = shopScene;
        scenes[Map.SceneType.shop3.ordinal()] = shopScene;
        scenes[Map.SceneType.shop4.ordinal()] = shopScene;
        scenes[Map.SceneType.shop5.ordinal()] = shopScene;
        
        Scene fishermanScene = new Scene();
        fishermanScene.setDescription(
                "A fisherman sits in a small boat nearby.");
        fishermanScene.setDisplaySymbol("FI");
        scenes[Map.SceneType.man1.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man2.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man3.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man4.ordinal()] = fishermanScene;
        scenes[Map.SceneType.man5.ordinal()] = fishermanScene;
        return scenes;
    }
}