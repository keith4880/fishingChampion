package byui.cit260.fishingChampion.view;

import byui.cit260.fishingChampion.model.Game;

/**
 *
 * @author brax10
 */
public class ShopView extends View {
    
    public ShopView() {
            super("\n----------------------------------------"
                + "\n              MARINA SHOP               |"
                + "\n----------------------------------------"
                + "\nB - Buy Bait                 $1 per Bait"
                + "\nF - Buy Fuel                $1 per Pound"
                + "\nE - Upgrade Fuel Efficiency         $100"
                + "\nM - Upgrade Max Weight      $2 per Pound"
                + "\nS - Sell Fish               $2 per Pound"
                + "\nQ - Exit Shop                           "
                + "\n----------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        int type;
        switch (choice) {
            case "B":
                type = Game.Item.bait.ordinal();
                break;
            case "F":
                type = Game.Item.fuel.ordinal();
                break;
            case "E":
                type = Game.Item.fuelEfficiency.ordinal();
                break;
            case "M":
                type = Game.Item.maxWeight.ordinal();
                break;
            case "S":
                type = Game.Item.fish.ordinal();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                        "Please enter a valid selection.");
                type = -1;
                break;
        }
        if (type > 0) {
            PurchaseView purchaseView = new PurchaseView(type);
            purchaseView.showAmount(type);
            purchaseView.display();
        }
        return false;
    }
}
