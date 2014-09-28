package bet.score;

import sport.GameNotPlayedException;
import sport.ScoreType;



import bet.Bet;


public class ScoreBet extends Bet {

	private ScoreType choice;
	private double limit;
	
	public ScoreBet(double limit, ScoreType choice) {
		this.limit = limit;
		this.choice = choice;
	}
	

	@Override
	public boolean isCorrect() throws GameNotPlayedException {
		return choice == this.getGame().getScore(limit);
	}


}
