package blackjack;

public class Card {
	private int value;
	private int suit;
	private boolean isUsed;
	String[] name = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	String[] suitname = {"Clubs", "Spades", "Diamonds", "Hearts"};
	
	public Card(int v, int s) {
		setValue(v);
		setSuit(s);
		setIsUsed(false);
	}
	public int getValue(){
		return value;
	}
	
	public String getValueName(){
		return name[value];
	}
	
	public void setValue(int v){
		value = v;
	}
	
	public String getSuit(){
		return suitname[suit];
	}
	
	public void setSuit(int s){
		suit = s;
	}
	
	public boolean getIsUsed(){
		return isUsed;
	}
	
	public void setIsUsed(boolean x){
		isUsed = x;
	}
}
