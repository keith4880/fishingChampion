/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.control;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.InventoryItem;
import java.util.ArrayList;

/**
 *
 * @author kyt09
 */
public class InventoryControl implements serializable {
    
    private final ArrayList<InventoryItem> items;
    
    public static InventoryItem[] createInventoryList() {
        InventoryItem[] inventory = new InventoryItem[6];
        
        InventoryItem money = new InventoryItem();
        money.setAmount(100);
        money.setMaxAmount(1000000);
        inventory[Game.Item.money.ordinal()] = money;
        
        InventoryItem fish = new InventoryItem();
        fish.setAmount(0);
        fish.setMaxAmount(1000000);
        inventory[Game.Item.fish.ordinal()] = fish;
        
        InventoryItem fuel = new InventoryItem();
        fuel.setAmount(30);
        fuel.setMaxAmount(1000000);
        inventory[Game.Item.fuel.ordinal()] = fuel;
        
        InventoryItem bait = new InventoryItem();
        bait.setAmount(20);
        bait.setMaxAmount(50);
        inventory[Game.Item.bait.ordinal()] = bait;
        
        InventoryItem maxWeight = new InventoryItem();
        maxWeight.setAmount(100);
        maxWeight.setMaxAmount(1000000);
        inventory[Game.Item.maxWeight.ordinal()] = maxWeight;
        
        InventoryItem fuelEfficiency = new InventoryItem();
        fuelEfficiency.setAmount(1);
        fuelEfficiency.setMaxAmount(1000000);
        inventory[Game.Item.fuelEfficiency.ordinal()] = fuelEfficiency;
        
        return inventory;
    }
    
    
           
    InventoryControl(){
        items = new ArrayList<>();
        
    }
    public void addItem(InventoryItem item){
        
        items.add(item);  
    }
    public void removeItem(String name) {
       
        for(InventoryItem item : items){
           
          
        }
   }
    //gives you the total no of items in the backpack follow the code on mapcontrol on line 401
    public int TotalNoOfItem(){
        int count = 0;
        
        for(InventoryItem item : items){
            count++;
        }
        return count;
    }
    
    public InventoryItem getItem(int index){
        int count = 0;
        
        for(InventoryItem item : items){
            if(count == index)
                return item;            
            count++;
            
        }
        return null; 
    }
   
}
