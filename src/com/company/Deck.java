package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Deck class implements all functionality needed from a real deck of cards
 * in a game of Badass BlackJack
 */
public class Deck {
	Card deck[];

	/**
	 * Constructor. Fill this deck's card array with all 52 unique values
	 */
	public Deck() {
		deck = new Card[52];
		int x = 0;
		for(int i = 1; i < 5; i++){
			for(int j = 1; j < 14; j++){
				deck[x] = new Card(j, i);
				x++;
			}
		}
	}

	/**
	 * Sets every card in this deck as not used. Used to reset the deck
	 */
	public void setIsUsed(){
		for(int i = 0; i < 52; i++){
			deck[i].setIsUsed(false);
		}
	}

	/**
	 * Randomized the order of cards in this deck's array of cards
	 */
	public void shuffleDeck(){
		setIsUsed();
		List<Card> list =  Arrays.asList(deck);
		Collections.shuffle(list);
		deck = list.toArray(deck);
	}

	/**
	 * Deals the top card of this deck. Best if this deck is randomized before
	 *
	 * @return Top card object of this deck
	 */
	public Card dealCard(){
		int i = 0;
		boolean loop = true; 
		while(loop == true){
			if(deck[i].getIsUsed() == true)
				i++;
			else{
				loop = false;
			}
		}
		deck[i].setIsUsed(true);
		return deck[i];
	}
}
