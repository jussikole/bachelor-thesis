package bet.result;


import javax.persistence.Entity;

import sport.GameNotPlayedException;
import bet.Bet;


@Entity
public class ResultBet extends Bet {
	
	private int homeTeamScore;
	private int awayTeamScore;
	
	public ResultBet() {
		
	}
	
	public ResultBet(int homeTeamScore, int awayTeamScore) {
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
	}

	@Override
	public boolean isCorrect() throws GameNotPlayedException {
		return homeTeamScore == this.getGame().getHomeTeamScore() && awayTeamScore == this.getGame().getAwayTeamScore();
	}

	public int getHomeTeamScore() {
		return homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}

	public int getAwayTeamScore() {
		return awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}



}
