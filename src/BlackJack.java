package blackjack;

public class BlackJack {

	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d.getCard().getValueName());
		System.out.println(d.getCard().getSuit());
		System.out.println(d.getCard().getValueName());
		System.out.println(d.getCard().getValueName());


	}

}
