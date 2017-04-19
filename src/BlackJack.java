
public class BlackJack {

	public static void main(String[] args) {
		Deck d = new Deck();

        Player player = new Player("Joe", 100);
        player.recieveCard(d.dealCard());
        player.recieveCard(d.dealCard());
        player.recieveCard(d.dealCard());
        player.recieveCard(d.dealCard());

		System.out.println(player.getName());
        System.out.println(player.getChips());
        Card[] cards = player.getHand();
        System.out.println("Card 0 value: " + cards[0].getValue());
        System.out.println("Card 0 suit: " + cards[0].getSuit());
        System.out.println("Card 1 value: " + cards[1].getValue());
        System.out.println("Card 1 value: " + cards[1].getSuit());
        System.out.println("Card 2 value: " + cards[2].getValue());
        System.out.println("Card 2 value: " + cards[2].getSuit());
        System.out.println("Card 3 value: " + cards[3].getValue());
        System.out.println("Card 3 value: " + cards[3].getSuit());
        System.out.println(player.getTotalCards());
        System.out.println(player.isBusted());


	}

}
