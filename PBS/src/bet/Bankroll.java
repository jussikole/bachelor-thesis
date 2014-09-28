package bet;

import java.util.ArrayList;

public class Bankroll {
	private double money;
	private ArrayList<Bet> bets;
	
	public Bankroll(double money) {
		this.money = money;
		this.bets = new ArrayList<Bet>();
	}
	
	public void applyBet(Bet bet) {
		this.bets.add(bet);
		this.money += bet.getAmount();
	}
	
	public void deposit(int amount) {
		money += amount;
	}
	
	public double getMoney() {
		return money;
	}
}
