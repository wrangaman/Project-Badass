package blackjack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	Card deck[]; 
	
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
	public void setIsUsed(){
		for(int i = 0; i < 52; i++){
			deck[i].setIsUsed(false);
		}
	}
	
	public void shuffleDeck(){
		List<Card> list =  Arrays.asList(deck);
		Collections.shuffle(list);
		deck = list.toArray(deck);
		setIsUsed();
	}
		
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
	
	
	public void printDeck(){
		for(int i = 0; i < 52; i++){
			System.out.println(deck[i].toString());
		}
	}
}
