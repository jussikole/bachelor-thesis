package bet.winner;

import sport.GameNotPlayedException;
import sport.WinnerType;

import bet.Bet;


public class WinnerBet extends Bet {

	private WinnerType choice;
	
	public WinnerBet(WinnerType choice) {
		this.choice = choice;
	}

	@Override
	public boolean isCorrect() throws GameNotPlayedException {
		return choice == this.getGame().getWinner();
	}
	
	public WinnerType getWinner() {
		return choice;
	}
	public void setWinner(WinnerType choice) {
		this.choice = choice;
	}

}
