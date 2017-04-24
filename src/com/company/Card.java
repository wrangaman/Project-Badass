package com.company;

/**
 * Card class implements the functionality a standard playing card in a game of Badass BlackJack by
 *   storing and managing its appropriate value/suit.
 *
 *   Created by Tyler Tiedt on 4/17/2017
 */
public class Card {
    private int value;
    private int suit;
    private boolean isUsed;
    String[] name = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    String[] suitname = {"Clubs", "Spades", "Diamonds", "Hearts"};

    /**
     * Parameterized constructor. Sets this cards value and suit accordingly
     *
     * @param v This card's value (0 - 12)
     * @param s This card's suit (0 = clubs; 1 = spades; 2 = diamonds; 3 = hearts)
     */
    public Card(int v, int s) {
        setValue(v);
        setSuit(s);
        setIsUsed(false);
    }

    /**
     * Simple getter for this card's integer value
     *
     * @return This card's value as an integer
     */
    public int getValue(){
        return value;
    }

    /**
     * Simple getter for this card's value as a string
     *
     * @return This card's value as a string
     */
    public String getValueName(){
        return name[value];
    }

    /**
     * Simple setter for this card's value
     *
     * @param v This card's value (0 - 12)
     */
    public void setValue(int v){
        value = v;
    }

    /**
     * Simple getter for this card's suit
     *
     * @return This card's suit as a string
     */
    public String getSuit(){
        return suitname[suit];
    }

    /**
     * Simple setter for this card's suit
     *
     * @param s This card's suit (0 = clubs; 1 = spades; 2 = diamonds; 3 = hearts)
     */
    public void setSuit(int s){
        suit = s;
    }

    /**
     * Simple getter for if this card has been used (in its current deck)
     *
     * @return true if this card has been 'dealt' false otherwise
     */
    public boolean getIsUsed(){
        return isUsed;
    }

    /**
     * Simple setter for if this card has been used (in its current deck)
     *
     * @param x True/false
     */
    public void setIsUsed(boolean x){
        isUsed = x;
    }

    /**
     * Function to output this card as a string. Outputs value and suit of this card as a string
     *
     * @return Value and suit of this card as string in form " [VALUE] of [SUIT] "
     */
    public String toString(){
        return getValueName() + " of " + getSuit();
    }
}
