package model.bet;

import java.util.Set;

import model.distribution.Distribution;
import model.distribution.ResultDistribution;
import model.distribution.ScoreDistribution;
import model.distribution.WinnerDistribution;

import bet.Bet;
import bet.Odds;
import bet.result.ResultBet;
import bet.result.ResultOdds;
import bet.score.ScoreBet;
import bet.score.ScoreOdds;
import bet.winner.WinnerBet;
import bet.winner.WinnerOdds;

public class BetProducer {
	private BetSizeRule betSizeRule;
	
	public BetProducer(BetSizeRule betSizeRule) {
		this.betSizeRule = betSizeRule;
	}
	
	public Set<WinnerBet> analyzeWinners(WinnerOdds odds, WinnerDistribution probabilities) {

	}
	
	public Set<ScoreBet> analyzeScores(ScoreOdds odds, ScoreDistribution probabilities) {
		return null;
	}
	
	public Set<ResultBet> analyzeResults(ResultOdds odds, ResultDistribution probabilities) {
		return null;
	}
}
