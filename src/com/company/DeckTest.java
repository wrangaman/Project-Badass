package com.company;

import static org.junit.Assert.*;
import org.junit.Test;

public class DeckTest {
    Deck test;
    String[] name = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    String[] suitname = {"Clubs", "Spades", "Diamonds", "Hearts"};

    public DeckTest() {

    }

    @Test
    public void deckSortedTest() {
        test = new Deck();
        boolean sorted = true;

        Card a = test.dealCard();
        Card b = test.dealCard();
        Card c = test.dealCard();
        Card d = test.dealCard();

        int diff = b.getValue() - a.getValue();
        assertEquals(1, diff);

        diff = c.getValue() - b.getValue();
        assertEquals(1, diff);

        diff = d.getValue() - c.getValue();
        assertEquals(1, diff);

        String suit = a.getSuit();
        assertEquals("Clubs", suit);

        suit = b.getSuit();
        assertEquals("Clubs", suit);

        suit = c.getSuit();
        assertEquals("Clubs", suit);

        suit = d.getSuit();
        assertEquals("Clubs", suit);
    }



    public static void main(String[] args) {
        DeckTest tester = new DeckTest();
    }
}
