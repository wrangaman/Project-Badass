package com.company;

import java.util.concurrent.ThreadLocalRandom;

/**
 * AIPlayer class extends functionality of Player class by adding 2 functions to automate the decision making
 *   necessary for a player in a game of BlackJack, namely deciding to hit/stand and how many chips to bet
 *
 * Created by Ben Rieckers on 4/18/2017.
 */
public class AIPlayer extends Player {
    private int difficulty;
    // List of names for potential AIPlayers
    private String[] names = {"Bruce", "Greg", "Octavious", "Jake", "Willis", "Beatrice", "Orval", "Opal", "Margie",
            "Jack", "Jill", "Lafawnda", "Destiny", "Rachael", "Lolita", "Spike", "Peach", "Daisy", "John", "Jane"};

    /**Calls Player class constructor with random name from name list and random number of chips.
     *  Also sets difficulty of AIPlayer
     * @param diff - difficulty of AIPlayer. (1 min - 3 max)
     */
    public AIPlayer(int diff) {
        // Make new 'empty' player
        super();

        // Give AIPlayer random name and random number of chips
        name = names[ThreadLocalRandom.current().nextInt(0, names.length)];
        chips = 100;

        difficulty = diff;
    }

    /**Flag for ATPlayer to hit or stand with their current hand. Based on modified dealer rules with the element of
     *  random chance based on the difficulty level of the AIPlayer
     * @return true if AIPlayer should 'hit' with their current hand, false otherwise
     */
    public boolean shouldHit() {
        boolean hit = false;
        int handSum = getTotalCards();
        int flag = ThreadLocalRandom.current().nextInt(0, 10); // Generate random number between 1-10

        // If hand is small or (90% chance)
        if(handSum < 17) {
            if(handSum < 13 || flag < 9) {
                hit = true;
            }
        }
        // Else still small chance of hitting
        else {
            if(flag == 9) { // 10% chance
                hit = true;
            }
        }
        return hit;
    }

    /**Calculates random number of chips to bet based on AIPlayer's difficulty
     *
     * @param min Current table minimum bet
     * @return Integer amount of chips for AIPlayer to bet.
     */
    public int amountToBet(int min) {
        int base = min + difficulty; // Smallest bet made by AIPlayer is min*difficulty
        return ThreadLocalRandom.current().nextInt(base, 2 * (base + min));
    }
}
