package com.company;

import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {
    Player tester;
    String name;
    int numOfChips;

    public PlayerTest() {
        name = "Tess";
        numOfChips = 500;
        tester = new Player(name, numOfChips);
    }

    @Test
    public void playerMainTest() {
        playerNameTest();
        playerChipsTest();
        //playerTotalCardsTest();
    }

    @Test
    public void playerNameTest() {
        System.out.println("Player's name should be: Tess -- Player's name is: " + tester.getName());
        assertEquals(name, tester.getName());
    }

    @Test
    public void playerChipsTest() {
        System.out.println("Player should have 500 chips -- Player has " + tester.getChips());
        assertEquals(numOfChips, tester.getChips());
    }

    @Test
    public void playerRecieveCardTest() {
        // Create new shuffled Deck
        Deck deck = new Deck();
        deck.shuffleDeck();

        Card card = deck.dealCard();
        tester.recieveCard(card);
    }

    @Test
    // Tests for player's hand sum, if blackjack and if busted
    public void playerTotalCardsTest() {
        tester = new Player(name, numOfChips);
        tester.recieveCard(new Card(1, 0));

        System.out.println("With a single ace, hand sum should be 11 -- Hand sum: " + tester.getTotalCards());
        assertEquals(11, tester.getTotalCards());

        tester.recieveCard(new Card(10, 0));
        System.out.println("With ace and ten, hand sum should be 21 meaning blackjack -- Hand sum: " + tester.getTotalCards() + " Blackjack: " + tester.blackJack);
        assertEquals(21, tester.getTotalCards());
        assertEquals(true, tester.blackJack);

    }

     public static void main(String[] args) {
     PlayerTest test = new PlayerTest();
     test.playerMainTest();
     }
}
