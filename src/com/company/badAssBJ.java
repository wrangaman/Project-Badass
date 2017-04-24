package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

/**MAIN FRAME
 * badAssBJ class creates and implements a custom JFrame used for the game of Badass BlackJack.
 *   Determines if user is new or returning, creates a tablePanel...
 *
 *   Created by Chin Huynh on 4/17/2017
 */
class badAssBJ extends JFrame{

    private JComboBox player;
    private final static String newline = "\n";
    private JTextArea dialogBox;
    private JButton startGame = new JButton("Start Game");
    private String[] name = {};
    private JLabel playerName = new JLabel("Name");
    private JLabel chips = new JLabel("Chips");
    private JTextField chip = new JTextField();
    private JPanel playerPanel = new JPanel();
    private JPanel mainTable;
    private JPanel actionPanel = new JPanel();
    private JPanel dialogPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JButton bet = new JButton("Place Bet");
    private JButton hit = new JButton("Hit");
    private JButton stand = new JButton("Stand");
    private JLabel amountToBet = new JLabel("Enter the amount to bet: ");
    private JTextField displayOfAmountToBet = new JTextField("");
    private JLabel pot = new JLabel("Pot: 0");

    private JToggleButton[] ai1Card = new JToggleButton[5];
    private JToggleButton[] ai2Card = new JToggleButton[5];
    private JToggleButton[] ai3Card = new JToggleButton[5];
    private JToggleButton[] ai4Card = new JToggleButton[5];
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

    private DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"", "Chin", "Tyler", "Ben"});
    AIPlayer[] AIPlayers;
    Player user;
    Deck deck;
    int roundPot;

    GridBagConstraints gbc;

    /*private Player[] players;

    public tablePanel(Player[] atTable) {
        players = atTable;

    }*/
    public badAssBJ() {
        pot.setFont(new Font("Arial", Font.PLAIN, 30));
        // Make editable combobox
        player = new JComboBox<>(model);
        player.setEditable(true);
        player.addActionListener(new ActionListener() {
            private int selectedIndex = -1;

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = player.getSelectedIndex();
                if (index >= 0) {
                    selectedIndex = index;
                } else if ("comboBoxEdited".equals(e.getActionCommand())) {
                    Object newValue = model.getSelectedItem();
                    model.addElement(newValue);
                    player.setSelectedItem(newValue);
                    selectedIndex = model.getIndexOf(newValue);
                }
            }
        });
        player.setSelectedIndex(0);


        startGame.addActionListener(new StartRoundAction());
        mainTable = new JPanel();
        mainTable.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        playerPanel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
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
        gbc.gridx = 0;
        gbc.gridy = 2;
        playerPanel.add(startGame, gbc);

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

        dialogBox = new JTextArea(10, 100);
        JScrollPane scrollPane = new JScrollPane(dialogBox);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dialogBox.setLineWrap(true);
        dialogBox.setWrapStyleWord(true);
        dialogBox.setEditable(false);
        dialogPanel.add(scrollPane);

        mainTable.setBackground(Color.GREEN);
        dialogPanel.setBackground(Color.GREEN);
        playerPanel.setBackground(Color.GREEN);
        actionPanel.setBackground(Color.GREEN);
        centerPanel.setBackground(Color.GREEN);
        add(mainTable, BorderLayout.NORTH);
        add(dialogPanel, BorderLayout.SOUTH);
        add(playerPanel, BorderLayout.WEST);
        add(actionPanel, BorderLayout.EAST);
        add(centerPanel, BorderLayout.CENTER);
        pack();
    }

    class StartRoundAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Make deck, player and AI objects
            user = new Player(player.getSelectedItem().toString(), Integer.parseInt(chip.getText()));
            AIPlayers = new AIPlayer[4];
            deck = new Deck();
            deck.shuffleDeck();
            for(int i = 0; i < 4; i++) {
                AIPlayers[i] = new AIPlayer(1);
            }
            // Deal initial 2 cards to every player
            dealFirstCards();
            // Update hand displays
            setPlayerHand(gbc, user.getNumOfCards(), user.getName());
            assignImage(user.getHand(), user.getNumOfCards(), playerCard);
            user.printHand();
            setAi1Hand(gbc, AIPlayers[0].getNumOfCards(), AIPlayers[0].getName());
            setAi2Hand(gbc, AIPlayers[1].getNumOfCards(), AIPlayers[1].getName());
            setAi3Hand(gbc, AIPlayers[2].getNumOfCards(), AIPlayers[2].getName());
            setAi4Hand(gbc, AIPlayers[3].getNumOfCards(), AIPlayers[3].getName());
            setPot(gbc);


            // Update dialog box
            dialogBox.append("Welcome " + user.getName() + "!" + newline);
            dialogBox.append("Place your bet." + newline);

            startGame.setEnabled(false);
            bet.addActionListener(new PlaceBetAction());
            revalidate();
            repaint();
        }

        public void dealFirstCards() {
            dealCard(user, deck);
            dealCard(user, deck);
            for(AIPlayer a : AIPlayers) {
                dealCardAI(a, deck);
                dealCardAI(a, deck);
            }
        }

        public void dealCard(Player p, Deck d) {
            p.recieveCard(d.dealCard());
        }

        public void dealCardAI(AIPlayer ai, Deck d) {
            ai.recieveCard(d.dealCard());
        }
    }

    class PlaceBetAction implements ActionListener {
        int userBet;

        public void actionPerformed(ActionEvent event) {
            roundPot = 0;
            userBet = Integer.parseInt(displayOfAmountToBet.getText());
            roundPot = roundPot + userBet;
            user.placeBet(userBet);
            dialogBox.append("You bet " + userBet + " chips" + newline);

            for(AIPlayer ai : AIPlayers){
                int aiBet = ai.amountToBet(1);
                ai.placeBet(aiBet);
                roundPot = roundPot + aiBet;
                dialogBox.append(ai.getName() + " bet " + aiBet + " chips" + newline);
            }
            pot.setText("Pot: " + roundPot);
            dialogBox.append("Total pot this round: " + roundPot + newline);
            bet.setEnabled(false);
            hit.addActionListener(new HitAction());
            stand.addActionListener(new StandAction());
        }
    }

    class HitAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(!user.isBusted() || user.getHand().length < 5) {
                user.recieveCard(deck.dealCard());
                setPlayerHand(gbc, user.getNumOfCards(), user.getName());
                assignImage(user.getHand(), user.getNumOfCards(), playerCard);
                dialogBox.append("Your new total is " + user.getTotalCards() + newline);
                user.printHand();
            }
            else {
                if(user.isBusted()) {
                    dialogBox.append("You busted!" + newline);
                }
                else {
                    dialogBox.append("Special Rule: If you have 5 cards in hand and are under 21 then you" +
                            "automatically gets 21." + newline);
                    user.setScore();
                }
            }
        }
    }

    class StandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            for(AIPlayer ai : AIPlayers) {
                while(ai.shouldHit() && ai.getTotalCards() < 21) {
                    Card temp = deck.dealCard();
                    ai.recieveCard(temp);
                    dialogBox.append(ai.getName() + " chose to hit." + newline );
                }
                if(ai.getTotalCards() > 21) {
                    dialogBox.append(ai.getName() + " busted." + newline);
                }
                else {
                    dialogBox.append(ai.getName() + " chose to stand." + newline);
                }
            }
            setAi1Hand(gbc, AIPlayers[0].getNumOfCards(), AIPlayers[0].getName());
            setAi2Hand(gbc, AIPlayers[1].getNumOfCards(), AIPlayers[1].getName());
            setAi3Hand(gbc, AIPlayers[2].getNumOfCards(), AIPlayers[2].getName());
            setAi4Hand(gbc, AIPlayers[3].getNumOfCards(), AIPlayers[3].getName());

            assignImage(AIPlayers[0].getHand(), AIPlayers[0].getNumOfCards(), ai1Card);
            assignImage(AIPlayers[1].getHand(), AIPlayers[1].getNumOfCards(), ai2Card);
            assignImage(AIPlayers[2].getHand(), AIPlayers[2].getNumOfCards(), ai3Card);
            assignImage(AIPlayers[3].getHand(), AIPlayers[3].getNumOfCards(), ai4Card);

            findAwardWinner();
            if(user.getChips() > 0) {
                bet.setEnabled(true);
                //for(int i = 0; i < 20; i++) {
                    dialogBox.append(newline);
                //}
                dialogBox.append("New round, place your bets." + newline);
            }
            user.resetHand();
            for(AIPlayer ai : AIPlayers) {
                ai.resetHand();
            }
            dealFirstCards();

            setAi1Hand(gbc, AIPlayers[0].getNumOfCards(), AIPlayers[0].getName());
            setAi2Hand(gbc, AIPlayers[1].getNumOfCards(), AIPlayers[1].getName());
            setAi3Hand(gbc, AIPlayers[2].getNumOfCards(), AIPlayers[2].getName());
            setAi4Hand(gbc, AIPlayers[3].getNumOfCards(), AIPlayers[3].getName());

            assignImage(AIPlayers[0].getHand(), AIPlayers[0].getNumOfCards(), ai1Card);
            assignImage(AIPlayers[1].getHand(), AIPlayers[1].getNumOfCards(), ai2Card);
            assignImage(AIPlayers[2].getHand(), AIPlayers[2].getNumOfCards(), ai3Card);
            assignImage(AIPlayers[3].getHand(), AIPlayers[3].getNumOfCards(), ai4Card);

            setPlayerHand(gbc, user.getNumOfCards(), user.getName());
            assignImage(user.getHand(), user.getNumOfCards(), playerCard);
        }

        public void findAwardWinner() {
            int maxScore = 0;
            if(user.getTotalCards() <= 21) {
                maxScore = user.getTotalCards();
            }
            int winPlayer = 0; // 0 = user. 1 = ai1. 2 = ai2 .......
            for(int i = 0; i < 4; i++) {
                if(AIPlayers[i].getTotalCards() > maxScore && AIPlayers[i].getTotalCards() <= 21) {
                    maxScore = AIPlayers[i].getTotalCards();
                    winPlayer = i + 1;
                }
            }

            if(winPlayer == 0) {
                user.getPot(roundPot);
                dialogBox.append("You won the round! Your total winnings are " + roundPot + " chips " + newline);
            }
            else {
                AIPlayers[winPlayer - 1].getPot(roundPot);
                dialogBox.append(AIPlayers[winPlayer - 1].getName() + " won this round with " + AIPlayers[winPlayer - 1].getTotalCards() + " for " + roundPot + " chips" + newline);
            }
        }

        public void dealFirstCards() {
            dealCard(user, deck);
            dealCard(user, deck);
            for(AIPlayer a : AIPlayers) {
                dealCardAI(a, deck);
                dealCardAI(a, deck);
            }
        }

        public void dealCard(Player p, Deck d) {
            p.recieveCard(d.dealCard());
        }

        public void dealCardAI(AIPlayer ai, Deck d) {
            ai.recieveCard(d.dealCard());
        }
    }

    private void assignImage(Card[] hand, int numOfCard, JToggleButton[] arr) {
        for (int i = 0; i < numOfCard; i++) {
            if (hand[i].getValueName().equals("Ace") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(aceHeart);
            }
            if (hand[i].getValueName().equals("Ace") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(aceDiamond);
            }
            if (hand[i].getValueName().equals("Ace") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(aceClub);
            }
            if (hand[i].getValueName().equals("Ace") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(aceSpade);
            }
            if (hand[i].getValueName().equals("Two") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(twoHeart);
            }
            if (hand[i].getValueName().equals("Two") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(twoDiamond);
            }
            if (hand[i].getValueName().equals("Two") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(twoClub);
            }
            if (hand[i].getValueName().equals("Two") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(twoSpade);
            }
            if (hand[i].getValueName().equals("Three") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(threeHeart);
            }
            if (hand[i].getValueName().equals("Three") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(threeDiamond);
            }
            if (hand[i].getValueName().equals("Three") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(threeClub);
            }
            if (hand[i].getValueName().equals("Three") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(threeSpade);
            }
            if (hand[i].getValueName().equals("Four") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(fourHeart);
            }
            if (hand[i].getValueName().equals("Four") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(fourDiamond);
            }
            if (hand[i].getValueName().equals("Four") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(fourClub);
            }
            if (hand[i].getValueName().equals("Four") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(fourSpade);
            }
            if (hand[i].getValueName().equals("Five") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(fiveHeart);
            }
            if (hand[i].getValueName().equals("Five") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(fiveDiamond);
            }
            if (hand[i].getValueName().equals("Five") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(fiveClub);
            }
            if (hand[i].getValueName().equals("Five") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(fiveSpade);
            }
            if (hand[i].getValueName().equals("Six") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(sixHeart);
            }
            if (hand[i].getValueName().equals("Six") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(sixDiamond);
            }
            if (hand[i].getValueName().equals("Six") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(sixClub);
            }
            if (hand[i].getValueName().equals("Six") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(sixSpade);
            }
            if (hand[i].getValueName().equals("Seven") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(sevenHeart);
            }
            if (hand[i].getValueName().equals("Seven") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(sevenDiamond);
            }
            if (hand[i].getValueName().equals("Seven") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(sevenClub);
            }
            if (hand[i].getValueName().equals("Seven") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(sevenSpade);
            }
            if (hand[i].getValueName().equals("Eight") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(eightHeart);
            }
            if (hand[i].getValueName().equals("Eight") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(eightDiamond);
            }
            if (hand[i].getValueName().equals("Eight") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(eightClub);
            }
            if (hand[i].getValueName().equals("Eight") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(eightSpade);
            }
            if (hand[i].getValueName().equals("Nine") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(nineHeart);
            }
            if (hand[i].getValueName().equals("Nine") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(nineDiamond);
            }
            if (hand[i].getValueName().equals("Nine") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(nineClub);
            }
            if (hand[i].getValueName().equals("Nine") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(nineSpade);
            }
            if (hand[i].getValueName().equals("Ten") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(tenHeart);
            }
            if (hand[i].getValueName().equals("Ten") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(tenDiamond);
            }
            if (hand[i].getValueName().equals("Ten") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(tenClub);
            }
            if (hand[i].getValueName().equals("Ten") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(tenSpade);
            }
            if (hand[i].getValueName().equals("Jack") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(jHeart);
            }
            if (hand[i].getValueName().equals("Jack") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(jDiamond);
            }
            if (hand[i].getValueName().equals("Jack") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(jClub);
            }
            if (hand[i].getValueName().equals("Jack") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(jSpade);
            }
            if (hand[i].getValueName().equals("Queen") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(qHeart);
            }
            if (hand[i].getValueName().equals("Queen") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(qDiamond);
            }
            if (hand[i].getValueName().equals("Queen") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(qClub);
            }
            if (hand[i].getValueName().equals("Queen") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(qSpade);
            }
            if (hand[i].getValueName().equals("King") && hand[i].getSuit().equals("Hearts")) {
                arr[i].setIcon(kHeart);
            }
            if (hand[i].getValueName().equals("King") && hand[i].getSuit().equals("Diamonds")) {
                arr[i].setIcon(kDiamond);
            }
            if (hand[i].getValueName().equals("King") && hand[i].getSuit().equals("Clubs")) {
                arr[i].setIcon(kClub);
            }
            if (hand[i].getValueName().equals("King") && hand[i].getSuit().equals("Spades")) {
                arr[i].setIcon(kSpade);
            }
        }
    }

    private void setPot(GridBagConstraints gbc){
        gbc.gridx = 7;
        gbc.gridy = 3;
        mainTable.add(pot, gbc);
    }

    private void setAi1Hand(GridBagConstraints gbc, int numOfCard, String s){
        gbc.gridx = 8;
        gbc.gridy = 0;
        mainTable.add(new JLabel(s + "'s Hand"), gbc);
        int xcor = 6;
        int ycor = 1;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 1) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                mainTable.add(ai1Card[i] = new JToggleButton(backOfCard), gbc);
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

    private void setPlayerHand(GridBagConstraints gbc, int numOfCard, String s){
        gbc.gridx = 5;
        gbc.gridy = 4;
        mainTable.add(new JLabel(s + "'s Hand"), gbc);
        int xcor = 3;
        int ycor = 5;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 5) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                mainTable.add(playerCard[i] = new JToggleButton(), gbc);
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

    private void setAi2Hand(GridBagConstraints gbc, int numOfCard, String s){
        gbc.gridx = 2;
        gbc.gridy = 2;
        mainTable.add(new JLabel(s + "'s Hand"), gbc);
        int xcor = 0;
        int ycor = 3;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 3) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                mainTable.add(ai2Card[i] = new JToggleButton(backOfCard), gbc);
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

    private void setAi3Hand(GridBagConstraints gbc, int numOfCard, String s){
        gbc.gridx = 11;
        gbc.gridy = 4;
        mainTable.add(new JLabel(s + "'s Hand"), gbc);
        int xcor = 9;
        int ycor = 5;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 5) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                mainTable.add(ai3Card[i] = new JToggleButton(backOfCard), gbc);
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

    private void setAi4Hand(GridBagConstraints gbc, int numOfCard, String s){
        gbc.gridx = 14;
        gbc.gridy = 2;
        mainTable.add(new JLabel(s + "'s Hand"), gbc);
        int xcor = 12;
        int ycor = 3;
        for (int i = 0; i <= numOfCard - 1; i++) {
            if (ycor == 3) {
                gbc.gridx = xcor;
                gbc.gridy = ycor;
                mainTable.add(ai4Card[i] = new JToggleButton(backOfCard), gbc);
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
