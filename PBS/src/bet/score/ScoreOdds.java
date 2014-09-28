package bet.score;

import container.ScoreContainer;
import sport.GameNotPlayedException;
import bet.Odds;
import model.distribution.ScoreDistribution;


public class ScoreOdds extends Odds implements ScoreContainer {

	private ScoreDistribution distribution;
	
	public ScoreOdds() {
		this.distribution = new ScoreDistribution();
	}
	

	@Override
	public double getUnderValue() {
		return distribution.getUnderValue();
	}

	@Override
	public double getOverValue() {
		return distribution.getOverValue();
	}

	@Override
	public void setUnderValue(int value) {
		distribution.setUnderValue(value);
	}

	@Override
	public void setOverValue(int value) {
		distribution.setOverValue(value);
	}

}
