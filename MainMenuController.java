//Filename: MainMenuController.java
//Author: Keidy Lopez
//Description:

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
    private MainMenuView mainMenu = new MainMenuView(this);

    public MainMenuController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("Use default CSV file")) {
                mainMenu.dispose();
                new GameController(new Game("cliker.csv"));
            } else if (source.getText().equals("Use my own CSV file")) {
                String file = JOptionPane.showInputDialog("Enter Filename:");
                if (!file.isEmpty()) {
                    mainMenu.dispose();
                    new GameController(new Game(file));
                }

            }
        }
    }
}