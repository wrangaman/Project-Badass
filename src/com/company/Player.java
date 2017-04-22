package com.company;

/**
 * Player class implements all functionality needed for a single player/user in a game of Badass BlackJack.
 *   Stores a Player's name, number of chips, cards (Card class obj) in hand and some other minor data implementation.
 *
 *   Created by Tyler Tiedt on 4/17/2017
 *   Edited by Ben Rieckers on 4/18/2017
 */
public class Player {
    String name;
    int chips;
    Card[] hand;
    int totalCards;
    boolean blackJack;

    /**
     * Empty constructor. Sets all values for this player to effectively null.
     *   Mainly used in AIPlayer class
     */
    public Player() {
        name = "";
        chips = 0;
        hand = new Card[5];
        totalCards = 0;
        blackJack = false;
    }

    /**
     * Parameterized constructor. Sets this player's name and number of chips, everything else null.
     *   Mainly used for user player
     *
     * @param n Name of this player
     * @param c Number of chips this player should start with
     */
    public Player(String n, int c) {
        name = n;
        chips = c;
        hand = new Card[5];
        totalCards = 0;
        blackJack = false;
    }

    /**
     * Simple getter for this player's name
     *
     * @return String name of this player
     */
    public String getName(){
        return name;
    }

    /**
     * Simple getter for this player's number of chips
     *
     * @return This player's current number of chips
     */
    public int getChips(){
        return chips;
    }

    public void recieveCard(Card c){
        if(totalCards < 5 && getTotalCards() < 22) {
            hand[totalCards] = c;
            totalCards++;
        }
    }

    /**
     * Flag for this player's hand sum exceeding 21
     *
     * @return True if this player's hand sum is over 21, false otherwise
     */
    public boolean isBusted() {
        if(21 < getTotalCards()) {
            return true;
        }
        return false;
    }

    /**
     * Remove number of chips for this player to bet from total chips
     *
     * @param x Number of chips this player is betting
     */
    public void placeBet(int x){
        chips = chips - x;
    }

    /**
     * Add number of chips won by this player to total chips
     *
     * @param x Number of chips won by this player
     */
    public void getPot(int x) {
        chips = chips + x;
    }

    /**
     * Simple getter for this player's hand
     *
     * @return Card array representing this player's hand
     */
    public Card[] getHand(){
        return hand;
    }

    /**
     * Sums all cards in this player's hand and returns result. If at least 1 ace in hand and
     *   ace can be high, adjusts hand sum accordingly
     *
     * @return This player's hand sum
     */
    public int getTotalCards(){
        int sum = 0;
        boolean ace = false;
        for(int i = 0; i < totalCards; i++){
            sum = sum + hand[i].getValue();
            if(hand[i].getValue() == 1) {
                ace = true;
            }
        }
        if(ace) {
            if(sum + 10 < 22) {
                sum = sum + 10;
            }
        }
        return sum;
    }
}
