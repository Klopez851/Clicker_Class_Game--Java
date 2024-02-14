/* File: GameController.java
 * Author: Dr. Huelsman
 * Created On: 12 Apr 2023
 * Purpose:
 * Notes:
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameController {
    private Game game;
    private GameView view;
    private ArrayList<ClickerObjectController> clickerObjs;
    private Timer ticker;
    public GameController(Game game){
        this.game = game;
        ticker = new Timer(1000, null);
        clickerObjs = new ArrayList<>();
        ArrayList<ClickerObjectView> clickerViews = new ArrayList<>();
        for(int i = 0; i < this.game.size(); i++){
            clickerObjs.add(new ClickerObjectController(this.game.get(i), this));
            clickerViews.add(clickerObjs.get(i).getView());
            ticker.addActionListener(clickerObjs.get(i));
        }
        ticker.start();
        view = new GameView(this.game, clickerViews);
    }

    public int getPrimaryInventory(){
        //Assume the first clicker object is the primary object.
        return game.get(0).getInventory();
    }

    public void spendPrimaryInventory(int cost){
        //Assume the first clicker object is the primary object.
        game.get(0).subInventory(cost);
        clickerObjs.get(0).getView().update_inventory();
    }

    public void addPrimaryInventory(int n){
        game.get(0).addInventory(n);
        clickerObjs.get(0).getView().update_inventory();
    }

    public static void main(String[] args){
        MainMenuController mainMenu = new MainMenuController();
    }
}

