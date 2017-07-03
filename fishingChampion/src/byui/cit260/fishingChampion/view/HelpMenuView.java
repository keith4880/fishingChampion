/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.fishingChampion.view;

/**
 *
 * @author kyt09
 */
public class HelpMenuView  extends View {
    public HelpMenuView() {
        super("\n----------------------------------------"
            + "\n| Help Menu                            |"
            + "\n----------------------------------------"
            + "\nO - Objective of the game"
            + "\nF - About Fuel"
            + "\nC - About Catching Fish"
            + "\nS - About Shopping"
            + "\nQ - Quit"
            + "\n----------------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();
        switch (choice) {
            case "O":
                this.displayObjective();
                break;
            case "F":
                this.displayFuel();
                break;
            case "C":
                this.displayCatch();
                break;
            case "S":
                this.displayShop();
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                                  "Please enter a valid selection.");
        }
        return false;
    }

    private void displayObjective() {
        this.console.println("\n----------------------------------------"
                         + "\nThe objective of this game is to collect"
                         + "\n500 pounds of fish. You accomplish this "
                         + "\nby moving your boat around the lake, "
                         + "\nbuying fuel and bait, and catching and "
                         + "\nselling fish."
                         + "\n----------------------------------------");
    }

    private void displayFuel() {
        this.console.println("\n----------------------------------------"
                         + "\nTo move around the lake, select the grid"
                         + "\nlocation you want to move to. Distance "
                         + "\nbetween you and your destination will "
                         + "\nbe calculated, and the fuel required for"
                         + "\nthe trip will be determined by distance "
                         + "\nand your boat's fuel efficiency. You can"
                         + "\nget more fuel and increase your boat's "
                         + "\nfuel efficiency at a shop. Be careful "
                         + "\nnot to run out of fuel if you're not "
                         + "\nnear a shop, or you'll be stranded!"
                         + "\n----------------------------------------");
    }

    private void displayCatch() {
        this.console.println("\n----------------------------------------"
                         + "\nIn order to catch a fish, you cast a "
                         + "\nline into the lake and a fish will "
                         + "\narrive. When you feel a tug on the line,"
                         + "\ntry to estimate the weight of the fish "
                         + "\nand pull accordingly. If you pull too "
                         + "\nhard or not hard enough for the fish's"
                         + "\nweight, it will get away, taking your "
                         + "\nbait with it."
                         + "\n----------------------------------------");
    }

    private void displayShop() {
        this.console.println("\n----------------------------------------"
                         + "\nAcross the lake, there are several shops"
                         + "\nyou can visit to buy everything you need"
                         + "\nto fish. At a shop, you can sell the "
                         + "\nfish you catch for money to buy bait, "
                         + "\nfuel for your boat, or boat upgrades "
                         + "\nto make your boat more fuel efficient "
                         + "\nor be able to carry more weight. Don't "
                         + "\nbuy too much though; your boat can only"
                         + "\ncarry so much fuel and fish before it "
                         + "\nsinks!"
                         + "\n----------------------------------------");
    }

}