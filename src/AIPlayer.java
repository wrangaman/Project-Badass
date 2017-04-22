/**
 * Created by Ben on 4/20/2017.
 */
import java.util.concurrent.ThreadLocalRandom;


public class AIPlayer extends Player {
    private int difficulty;
    // List of names for potential AIPlayers
    private String[] names = {"Jack", "Jill", "John", "Jane"};

    /**Calls Player class constructor with random name from name list and random number of chips.
     *  Also sets difficulty of AIPlayer
     * @param diff - difficulty of AIPlayer. (1 min - 3 max)
     */
    public AIPlayer(int diff) {
        // Make new 'empty' player
        super();

        // Give AIPlayer random name and random number of chips
        name = names[ThreadLocalRandom.current().nextInt(0, names.length)];
        chips = ThreadLocalRandom.current().nextInt(50, 200);

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
        int base = min * difficulty; // Smallest bet made by AIPlayer is min*difficulty
        return ThreadLocalRandom.current().nextInt(base, (base + min));
    }
}
