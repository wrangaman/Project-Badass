package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Deck class implements the functionality of a deck of cards by creating and managing an array
 *   of 52 Card class objects, allowing everything needed from a deck of cards in a game of
 *   Badass BlackJack
 *
 * Created by Tyler Tiedt on 4/17/2017
 */
public class Deck {
    Card deck[];

    /**
     * Constructor. Creates array of Card class objects and new Card objects for every card
     *   in a standard deck
     */
    public Deck() {
        deck = new Card[52];
        int x = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                deck[x] = new Card(j, i);
                x++;
            }
        }
    }

    /**
     * Resets a deck of cards by going through the entire deck and setting each card as 'not used'
     */
    public void setIsUsed(){
        for(int i = 0; i < 52; i++){
            deck[i].setIsUsed(false);
        }
    }

    /**
     * Randomized the order of cards in this deck using Java's List.shuffle method
     */
    public void shuffleDeck(){
        List<Card> list =  Arrays.asList(deck);
        Collections.shuffle(list);
        deck = list.toArray(deck);
        setIsUsed();
    }

    /**
     * Finds and returns the first unused Card class object in this (ideally shuffled) deck
     *
     * @return First unused card in this deck
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
