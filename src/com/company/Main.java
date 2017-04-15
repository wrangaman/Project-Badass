package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        badAssBJ mainFrame = new badAssBJ();
        mainFrame.setSize(1000, 750);
        mainFrame.setTitle("BadAss BlackJack");
        //mainFrame.setBackground(Color.GREEN);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
