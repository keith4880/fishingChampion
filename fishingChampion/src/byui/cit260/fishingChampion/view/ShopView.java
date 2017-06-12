package byui.cit260.fishingChampion.view;

import java.util.Scanner;

/**
 *
 * @author brax10
 */
public class ShopView {
    private final String menu;
    public ShopView() {
            this.menu = "\n----------------------------------------"
                      + "\n"
                    + "\n----------------------------------------"
                    + "\n| Marina Shop                            |"
                      + "\nB - Buy Bait"
                      + "\nF - Buy Fuel"
                      + "\nU - Upgrade Boat"
                      + "\nS - Sell Fish"
                      + "\nX - Exit Shop"
                      + "\n----------------------------------------";
    }
    public void displayShopView() {
        boolean done = false;
        System.out.println(menu);
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X"))
                return;
            done = this.doAction(menuOption);
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        while (!valid) {
            System.out.println("\nSelect a menu option using the keyboard.");
            value = keyboard.nextLine();
            value = value.trim();
            if (value.length() < 1) {
                System.out.println("\nYou must enter a selection.");
                continue;
            }
            break;
        }
        return value;
    }

    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "B":
                this.buyBait();
                System.out.println(menu);
                break;
            case "F":
                this.buyFuel();
                System.out.println(menu);
                break;
            case "U":
                this.upgradeBoat();
                System.out.println(menu);
                break;
            case "S":
                this.sellFish();
                System.out.println(menu);
                break;
            default:
                System.out.println("\n*** Please enter a valid selection.");
                System.out.println(menu);
                break;
        }
        return false;
    }

    private void buyBait() {
        System.out.println("*** buyBait function called ***");
    }

    private void buyFuel() {
        System.out.println("*** buyFuel function called ***");
    }

    private void upgradeBoat() {
        System.out.println("*** upgradeBoat function called ***");
    }

    private void sellFish() {
        System.out.println("*** sellFish function called ***");
    }
}
