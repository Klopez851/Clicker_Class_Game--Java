/* File: ClickerObject.java
 * Author: Dr. Huelsman
 * Created On: 03 Apr 2023
 * Purpose:
 * Notes:
 */

public class ClickerObject {
    private String name;
    private int cost;
    private int production;
    private int timing;
    private int inventory;

    public ClickerObject(String name, int cost, int production, int timing) {
        this.name = name;
        this.cost = cost;
        this.production = production;
        this.timing = timing;
        inventory = 0;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getProduction() {
        return production;
    }

    public int getTiming() {
        return timing;
    }

    public int getInventory() {
        return inventory;
    }

    public boolean loops() {
        return (timing < 0);
    }

    public int addInventory(int n) {
        inventory += n;
        return inventory;
    }

    public int subInventory(int n) {
        inventory -= n;
        return inventory;
    }

}
