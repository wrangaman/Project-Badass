import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	private Card deck[] = new Card[52];

	public Deck() {
		int x = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 13; j++){
				deck[x] = new Card(j, i);
				x++;
			}
		}
	}
	
	public Card dealCard(){
		int c = ThreadLocalRandom.current().nextInt(0, 53);
		while(deck[c].getIsUsed()){
			c = ThreadLocalRandom.current().nextInt(0, 53);
		}
		deck[c].setIsUsed(true);
		return deck[c];
	}


}
