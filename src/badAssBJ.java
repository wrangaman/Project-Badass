package com.company;

import javax.swing.*;
import java.awt.*;

class badAssBJ extends JFrame{

    private String[] name = {};
    private JComboBox<?> player = new JComboBox<Object>(name);
    private JLabel playerName = new JLabel("Name");
    private JLabel chips = new JLabel("Chips");
    private JTextField chip = new JTextField();
    private JPanel playerPanel = new JPanel();
    private tablePanel mainTable;
    private JPanel actionPanel = new JPanel();
    private JPanel dialogPanel = new JPanel();
    private JButton bet = new JButton("Place Bet");
    private JButton hit = new JButton("Hit");
    private JButton stand = new JButton("Stand");
    private JSlider amountToBet = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
    private JTextField displayOfAmountToBet = new JTextField("");

    public badAssBJ(){
        mainTable = new tablePanel();

        playerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        playerPanel.add(playerName, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        playerPanel.add(player, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        playerPanel.add(chips, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        playerPanel.add(chip, gbc);

        actionPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        actionPanel.add(amountToBet, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        actionPanel.add(displayOfAmountToBet, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        actionPanel.add(bet, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        actionPanel.add(hit, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        actionPanel.add(stand, gbc);

        add(mainTable, BorderLayout.NORTH);
        add(dialogPanel, BorderLayout.SOUTH);
        add(playerPanel, BorderLayout.WEST);
        add(actionPanel, BorderLayout.EAST);
        pack();
    }
}
