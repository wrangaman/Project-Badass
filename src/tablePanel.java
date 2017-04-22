package com.company;

import javax.swing.*;
import java.awt.*;

public class tablePanel extends JPanel{

    Deck d = new Deck;
    Player p = new Player("john",100);

    private JToggleButton[] dealerCard = new JToggleButton[5];
    private JToggleButton[] ai1Card = new JToggleButton[5];
    private JToggleButton[] ai2Card = new JToggleButton[5];
    private JToggleButton[] ai3Card = new JToggleButton[5];
    private JToggleButton[] playerCard = new JToggleButton[5];

    private ImageIcon aceHeart = new ImageIcon("images/Aheart.png");
    private ImageIcon aceDiamond = new ImageIcon("images/Adiamond.png");
    private ImageIcon aceClub = new ImageIcon("images/Aclub.png");
    private ImageIcon aceSpade = new ImageIcon("images/Aspade.png");

    private ImageIcon twoHeart = new ImageIcon("images/2heart.png");
    private ImageIcon twoDiamond = new ImageIcon("images/2diamond.png");
    private ImageIcon twoClub = new ImageIcon("images/2club.png");
    private ImageIcon twoSpade = new ImageIcon("images/2spade.png");

    private ImageIcon threeHeart = new ImageIcon("images/3heart.png");
    private ImageIcon threeDiamond = new ImageIcon("images/3diamond.png");
    private ImageIcon threeClub = new ImageIcon("images/3club.png");
    private ImageIcon threeSpade = new ImageIcon("images/3spade.png");

    private ImageIcon fourHeart = new ImageIcon("images/4heart.png");
    private ImageIcon fourDiamond = new ImageIcon("images/4diamond.png");
    private ImageIcon fourClub = new ImageIcon("images/4club.png");
    private ImageIcon fourSpade = new ImageIcon("images/4spade.png");

    private ImageIcon fiveHeart = new ImageIcon("images/5heart.png");
    private ImageIcon fiveDiamond = new ImageIcon("images/5diamond.png");
    private ImageIcon fiveClub = new ImageIcon("images/5club.png");
    private ImageIcon fiveSpade = new ImageIcon("images/5spade.png");

    private ImageIcon sixHeart = new ImageIcon("images/6heart.png");
    private ImageIcon sixDiamond = new ImageIcon("images/6diamond.png");
    private ImageIcon sixClub = new ImageIcon("images/6club.png");
    private ImageIcon sixSpade = new ImageIcon("images/6spade.png");

    private ImageIcon sevenHeart = new ImageIcon("images/7heart.png");
    private ImageIcon sevenDiamond = new ImageIcon("images/7diamond.png");
    private ImageIcon sevenClub = new ImageIcon("images/7club.png");
    private ImageIcon sevenSpade = new ImageIcon("images/7spade.png");

    private ImageIcon eightHeart = new ImageIcon("images/8heart.png");
    private ImageIcon eightDiamond = new ImageIcon("images/8diamond.png");
    private ImageIcon eightClub = new ImageIcon("images/8club.png");
    private ImageIcon eightSpade = new ImageIcon("images/8spade.png");

    private ImageIcon nineHeart = new ImageIcon("images/9heart.png");
    private ImageIcon nineDiamond = new ImageIcon("images/9diamond.png");
    private ImageIcon nineClub = new ImageIcon("images/9club.png");
    private ImageIcon nineSpade = new ImageIcon("images/9spade.png");

    private ImageIcon tenHeart = new ImageIcon("images/10heart.png");
    private ImageIcon tenDiamond = new ImageIcon("images/10diamond.png");
    private ImageIcon tenClub = new ImageIcon("images/10club.png");
    private ImageIcon tenSpade = new ImageIcon("images/10spade.png");

    private ImageIcon jHeart = new ImageIcon("images/Jheart.png");
    private ImageIcon jDiamond = new ImageIcon("images/Jdiamond.png");
    private ImageIcon jClub = new ImageIcon("images/Jclub.png");
    private ImageIcon jSpade = new ImageIcon("images/Jspade.png");

    private ImageIcon qHeart = new ImageIcon("images/Qheart.png");
    private ImageIcon qDiamond = new ImageIcon("images/Qdiamond.png");
    private ImageIcon qClub = new ImageIcon("images/Qclub.png");
    private ImageIcon qSpade = new ImageIcon("images/Qspade.png");

    private ImageIcon kHeart = new ImageIcon("images/Kheart.png");
    private ImageIcon kDiamond = new ImageIcon("images/Kdiamond.png");
    private ImageIcon kClub = new ImageIcon("images/Kclub.png");
    private ImageIcon kSpade = new ImageIcon("images/Kspade.png");

    private ImageIcon backOfCard = new ImageIcon("images/back.png");
    private ImageIcon bulldogFace = new ImageIcon("images/bulldog face.png");

    public tablePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        setDealerHand(gbc, 5);
        setPlayerHand(gbc, 5);
        setAi1Hand(gbc, 5);
        setAi2Hand(gbc, 5);
        setAi3Hand(gbc, 5);
    }

    private void assignImage(int numOfCard) {
        for (int i = 0; i < numOfCard; i++) {
            if(p.getHand[i].getValueName().equ){
                if()
            }
        }
    }

    private void setDealerHand(GridBagConstraints gbc, int numOfCard){
        gbc.gridx = 8;
        gbc.gridy = 0;
        add(new JLabel("Dealer's Hand"), gbc);
        int xcor = 6;
        int ycor = 1;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 1) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                add(dealerCard[i] = new JToggleButton(), gbc);
                ycor = 2;
            }
            if(ycor == 2){
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                ycor = 1;
                xcor++;
            }
        }
    }

    private void setPlayerHand(GridBagConstraints gbc, int numOfCard){
        gbc.gridx = 5;
        gbc.gridy = 4;
        add(new JLabel("Player's Hand"), gbc);
        int xcor = 3;
        int ycor = 5;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 5) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                add(playerCard[i] = new JToggleButton(), gbc);
                ycor = 6;
            }
            if(ycor == 6){
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                ycor = 5;
                xcor++;
            }
        }
    }

    private void setAi1Hand(GridBagConstraints gbc, int numOfCard){
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(new JLabel("AI_1's Hand"), gbc);
        int xcor = 0;
        int ycor = 3;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 3) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                add(ai1Card[i] = new JToggleButton(), gbc);
                ycor = 4;
            }
            if(ycor == 4){
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                ycor = 3;
                xcor++;
            }
        }
    }

    private void setAi2Hand(GridBagConstraints gbc, int numOfCard){
        gbc.gridx = 11;
        gbc.gridy = 4;
        add(new JLabel("AI_2's Hand"), gbc);
        int xcor = 9;
        int ycor = 5;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 5) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                add(ai2Card[i] = new JToggleButton(), gbc);
                ycor = 6;
            }
            if(ycor == 6){
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                ycor = 5;
                xcor++;
            }
        }
    }

    private void setAi3Hand(GridBagConstraints gbc, int numOfCard){
        gbc.gridx = 14;
        gbc.gridy = 2;
        add(new JLabel("AI_3's Hand"), gbc);
        int xcor = 12;
        int ycor = 3;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 3) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                add(ai3Card[i] = new JToggleButton(), gbc);
                ycor = 4;
            }
            if(ycor == 4){
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                ycor = 3;
                xcor++;
            }
        }
    }
}
