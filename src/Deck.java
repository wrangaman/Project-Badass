package blackjack;

public class Deck {
	Card deck[] = new Card[52]; 
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
		int c = (int)((Math.random() * 52) + 1);
		while(deck[c].getIsUsed()){
			c = (int)((Math.random() * 52) + 1);
		}
		deck[c].setIsUsed(true);
		return deck[c];
	}
	
	public Card
}
