package com.company;

public class Player {
    String name;
    int chips;
    Card[] hand;
    int totalCards;
    boolean blackJack;

    public Player() {
        name = "";
        chips = 0;
        hand = new Card[5];
        totalCards = 0;
        blackJack = false;
    }

    public Player(String n, int c) {
        name = n;
        chips = c;
        hand = new Card[5];
        totalCards = 0;
        blackJack = false;
    }

    public String getName(){
        return name;
    }

    public int getChips(){
        return chips;
    }

    public void recieveCard(Card c){
        if(totalCards < 5 && getTotalCards() < 22) {
            hand[totalCards] = c;
            totalCards++;
        }
    }

    /** Check if player hand sum > 21
     *
     * @return
     */
    public boolean isBusted() {
        if(21 < getTotalCards()) {
            return true;
        }
        return false;
    }

    /** Remove number of chips bet from total chips
     *
     * @param x
     */
    public void placeBet(int x){
        chips = chips - x;
    }

    /** Add number of chips won to total chips
     *
     * @param x
     */
    public void getPot(int x) {
        chips = chips + x;
    }

    /** Return card array of hand
     *
     * @return
     */
    public Card[] getHand(){
        return hand;
    }

    /** Returns hand sum. If ace can be valued
     *
     * @return
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
