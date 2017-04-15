package blackjack;

public class Player {
	String name;
	int chips;
	Deck[] hand = new Deck[5];
	int totalCards;
	boolean ifBust;
	int index = 0;
	Deck d = new Deck();
	
	public Player() {
		receiveCard();
		receiveCard();
	}
	
	public void receiveCard(){
		hand[index].getCard();
		index++;
	}
	
	public int placeBet(int x){
		setChips(getChips() - x);
		return x;
	}
	
	public Card getHand(){
		
	}
	
	public int getTotalCards(){
		int sum = 0;
		for(int i = 0; i < hand.length; i++){
			hand[i].get
		}
	}
	
	public void setTotalCards(){
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public int getChips(){
		return chips;
	}
	
	public void setChips(int c){
		chips = c;
	}
	
	public void hit(){
		
	}
	
	public void stand(){
		
	}

}
