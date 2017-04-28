package com.company;

/**
 * Player class implements all functionality for a player in a game of Badass BlackJack.
 */
public class Player {
	String name;
	int chips;
	Card[] hand;
	int totalCards;
	boolean blackJack;
	boolean isOut;

	/**
	 * Parameterized constructor. Sets this players name and chips
	 *
	 * @param n This player's name
	 * @param c This player's chips
	 */
	public Player(String n, int c) {
		name = n;
		chips = c;
		hand = new Card[5];
		totalCards = 0;
	}

	/**
	 * Constructor. Sets all values of this player to functionally null
	 */
	public Player() {
		name = "";
		chips = 0;
		hand = new Card[5];
		totalCards = 0;
		blackJack = false;
		isOut = false;
	}

	/**
	 * Simple getter for this player's name
	 *
	 * @return This player's name as a string
	 */
	public String getName(){
		return name;
	}

	/**
	 * Simple getter for this player's chips
	 *
	 * @return This player's number of chips as an integer
	 */
	public int getChips(){
		return chips;
	}

	/**
	 * Flag for if this player has lost their round of blackjack
	 *
	 * @return true if the player has reached 0 chips, false otherwise
	 */
	public boolean getIsOut(){
		return isOut;
	}

	/**
	 * Setter for if this player has lost their round
	 *
	 * @param x false if this player has lost their round, true otherwise
	 */
	public void setIsOut(boolean x){
		isOut = x;
	}

	/**
	 * Implements functionality for this player to be dealt a card in a game of blackjack
	 * Adds passed in card
	 *
	 * @param c Card object to deal to player
	 */
	public void recieveCard(Card c){
		if(totalCards < 5 && getTotalCards() < 22 && !isOut){
			hand[totalCards] = c;
			totalCards++;
		}
	}

	public int getNumOfCards() {
		return totalCards;
	}

	/** Check if player hand sum is less than or equal to 21
	 *
	 * @return true if this player's hand sum is less than or equal to 21, false otherwise
	 */
	public boolean isBusted() {
		if(21 < getTotalCards()) {
			return true;
		}
		return false;
	}

	/** Remove number of chips bet from total chips
	 *
	 * @param x Chips to remove from this player's chips
	 *
	 */
	public void placeBet(int x){
		chips = chips - x;
	}

	/** Add number of chips won to total chips
	 *
	 * @param x Chips to add to this players chips
	 */
	public void getPot(int x) {
		chips = chips + x;
	}

	/** Return card array of hand
	 *
	 * @return Array of cards that make up this player's hand
	 */
	public Card[] getHand(){
		return hand;
	}

	/** Returns hand sum. If ace can be valued
	 *
	 * @return Sum of face value of all cards in this player's hand
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
	/**
	 * Prints this player's hand
	 */
	public void printHand(){
		for(Card i : hand){
			if(i != null)
				System.out.println(i.toString());
		}
	}
	/** Set score to 21 if player if has 5 card in hand and total is under 21
	 *
	 * @return This player's total number of cards
	 */
	public int setScore(){
		int total = getTotalCards();
		if(totalCards == 5 && getTotalCards() <= 21){
			total = 21;
			blackJack = true;
		}
		return total;
	}

	/**
	 * Resets this player's hand
	 */
	public void resetHand(){
		hand = new Card[5];
		totalCards = 0;
	}
}
