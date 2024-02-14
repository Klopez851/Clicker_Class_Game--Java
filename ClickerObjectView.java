/* File: ClickerObjectView.java
 * Author: Dr. Huelsman
 * Created On: 03 Apr 2023
 * Purpose:
 * Notes:
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClickerObjectView extends JPanel {
    //Data
    private ClickerObject piece;
    //UI Elements
    private JLabel name;
    private JLabel cost;
    private JLabel production;
    private JLabel timing;
    private JLabel inventory;
    private JButton purchase_btn, increase_production;

    public ClickerObjectView(ClickerObject piece, ActionListener btn_listener) {
        super(new GridLayout(4, 4));
        this.piece = piece;
        name = new JLabel(this.piece.getName());
        cost = new JLabel(Integer.toString(this.piece.getCost()));
        production = new JLabel(Integer.toString(this.piece.getProduction()));
        timing = new JLabel(Integer.toString(this.piece.getTiming()));
        inventory = new JLabel(Integer.toString(this.piece.getInventory()));
        purchase_btn = new JButton("Add");
        purchase_btn.addActionListener(btn_listener);

        add(name);
        //Blank spaces
        for (int i = 0; i < 3; i++) {
            add(new JPanel());
        }
        add(new JLabel("Cost:"));
        add(new JLabel("Prod:"));
        add(new JLabel("Timing:"));
        add(new JLabel("Inv:"));
        add(cost);
        add(production);
        add(timing);
        add(inventory);
        add(purchase_btn);
    }

    public void update_inventory() {
        inventory.setText(Integer.toString(piece.getInventory()));
        update(this.getGraphics());
    }

}
