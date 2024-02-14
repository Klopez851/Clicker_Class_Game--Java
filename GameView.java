/* File: GameView.java
 * Author: Dr. Huelsman
 * Created On: 03 Apr 2023
 * Purpose:
 * Notes:
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameView extends JFrame{
    private Game game;

    private JPanel main_panel;

    public GameView(Game game, ArrayList<ClickerObjectView> clickerViews){
        super("Swing Clicker");
        this.game = game;
        main_panel = new JPanel(new GridLayout(this.game.size(), 1));
        for(ClickerObjectView v : clickerViews){
            main_panel.add(v);
        }
        add(main_panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
