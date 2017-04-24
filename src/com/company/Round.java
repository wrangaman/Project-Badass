package blackjack;

import java.util.Scanner;

public class Round {
	Scanner scan = new Scanner(System.in);
	Scanner in = new Scanner(System.in);
	Deck d = new Deck();
	Player[] player;
	String[] name = {"Dealer", "John", "Greg", "Timn", "Rob"};
	int pot;
	public Round() {
		player = new Player[5];
		for(int i = 0; i < player.length; i++){
			player[i] = new Player(name[i], 100);
		}
	}
	
	public void playRound(){
		isOut(player);
		if(findWinner(player) == true){
		}
		else{
			d.shuffleDeck();
			pot = 0;
			for(Player p : player){
				if(!p.getIsOut()){
					dealFirstCards(p, d);
					displayHand(p);
					pot += placeBet(p, scan);
				}
			}
			for(Player e : player){
				if(!e.getIsOut()){
					hitOrStand(e, d, in);
				}
			}
			System.out.println(getWinner(player).getName() + " won $" + pot);
			getWinner(player).getPot(pot);
			for(Player s : player){
				s.resetHand();
			}
		}
	}
	
	public void dealFirstCards(Player player, Deck d){
		player.recieveCard(d.dealCard());
		player.recieveCard(d.dealCard());
	}
	
	public void displayHand(Player player){
		System.out.println("Player: " + player.getName() + " - $" + player.getChips());
		System.out.println("----Your Hand----");		
        player.printHand();
        System.out.println("-----------------");
        System.out.println(player.getTotalCards());
	}
	
	public int placeBet(Player player, Scanner n){
		int bet = 0;
		int max = player.getChips();
		System.out.print(player.getName() + " has $" + player.getChips() + ", Place your bet: ");
		bet = n.nextInt();
		if(bet > max){
			System.out.println("You don't have enough money.");
			System.out.print("You have $" + player.getChips() + ", Place your bet: ");
			bet = n.nextInt();
		}
		player.placeBet(bet);
		return bet;
	}
	
	public void hitOrStand(Player player, Deck d, Scanner n){
		System.out.println();
		displayHand(player);
        System.out.print("Press 'h' to hit or 's' to stand: ");
        String c = n.nextLine();
		if(c.equals("h")){
			player.recieveCard(d.dealCard());
			displayHand(player);
			System.out.println("Your total: " + player.getTotalCards() + "\n");
			if(!player.isBusted() && handLength(player) != 5){
				hitOrStand(player, d, n);
			}
			else{
				System.out.println("Bust? " + player.isBusted() + "\nYou busted or have 5 cards.");
			}
		}
		else{
			System.out.println("Stand");
			displayHand(player);
			System.out.println("Your total: " + player.getTotalCards() + "\n");
		}
	}
	
	public Player getWinner(Player[] player){
		Player winner = null;
		int winningtotal = 0;
		for(Player p: player){
			if(p.setScore() > winningtotal && !p.isBusted() && !p.getIsOut()){
				winner = p;
				winningtotal = p.setScore();
			}
		}
		return winner;
	}
	
	public void isOut(Player[] player){
		for(Player p : player){
			if(p.getChips() == 0){
				p.setIsOut(true);
				System.out.println(p.getName() + " is out.");
			}
		}
	}
	
	public boolean findWinner(Player[] player){
		int totalout = 0;
		for(Player p : player){
			if(p.getIsOut()){
				totalout++;
			}
		}
		if(totalout == player.length - 1){
			System.out.println(player[0].getName() + " won the game.");
			return true;
		}
		return false;
	}
	
	public int handLength(Player player){
		int count = 0;
		for(Card i : player.getHand()){
			if(i != null)
				count++;
		}
		return count;
	}
}
