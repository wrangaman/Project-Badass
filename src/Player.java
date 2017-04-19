
public class Player {
	String name;
	int chips;
	Card[] hand;
	int totalCards;
	
	public Player(String n, int c) {
		name = n;
		chips = c;
		hand = new Card[5];
		totalCards = 0;
	}


	public String getName(){
		return name;
	}

	public int getChips(){
		return chips;
	}
	
	public void recieveCard(Card c){
		if(totalCards < 5) {
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

	/** Returns hand sum
	 *
	 * @return
	 */
	public int getTotalCards(){
		int sum = 0;
		for(int i = 0; i < totalCards; i++){
			sum = sum + hand[i].getValue();
		}
		return sum;
	}
}
