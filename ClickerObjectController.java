/* File: ClickerObjectController.java
 * Author: Dr. Huelsman
 * Created On: 05 Apr 2023
 * Purpose:
 * Notes:
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickerObjectController implements ActionListener {
    private ClickerObject obj;
    private ClickerObjectView view;
    private GameController gc;
    private int tickCounter;

    public ClickerObjectController(ClickerObject obj, GameController gc) {
        this.obj = obj;
        this.gc = gc;
        view = new ClickerObjectView(this.obj, this);
        tickCounter = 0;
    }

    public ClickerObjectView getView() {
        return view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("Add")) {
                if (gc.getPrimaryInventory() >= obj.getCost()) {
                    obj.addInventory(1);
                    gc.spendPrimaryInventory(obj.getCost());
                    view.update_inventory();
                }
            }
        } else if (e.getSource() instanceof Timer) {
            tickCounter += 1;
            if (obj.getTiming() != -1 && tickCounter % obj.getTiming() == 0) {
                gc.addPrimaryInventory(obj.getInventory() * obj.getProduction());
            }
        }

    }
}