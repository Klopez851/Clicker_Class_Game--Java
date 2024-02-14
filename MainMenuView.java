//Filename: MainMenuView.java
//Author: Keidy Lopez
//Description:

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {
    private JPanel mainPanel = new JPanel(new GridLayout(3,1));
    private JButton defaultFile, myOwnFile;


    public MainMenuView(ActionListener listener){
        super("Main Menu");
        defaultFile = new JButton("Use default CSV file");
        myOwnFile = new JButton("Use my own CSV file");

        defaultFile.addActionListener(listener);
        myOwnFile.addActionListener(listener);

        mainPanel.add(new JLabel("Clicker Game"));
        mainPanel.add(defaultFile);
        mainPanel.add(myOwnFile);

        add(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

    }



}
