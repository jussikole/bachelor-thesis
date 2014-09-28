package bet.winner;

import container.WinnerContainer;
import sport.GameNotPlayedException;
import bet.Odds;
import model.distribution.WinnerDistribution;


public class WinnerOdds extends Odds implements WinnerContainer {

	private WinnerDistribution distribution;
	
	public WinnerOdds() {
		super();
		this.distribution = new WinnerDistribution();
	}
	

	@Override
	public double getHomeValue() {
		return distribution.getHomeValue();
	}

	@Override
	public double getDrawValue() {
		return distribution.getDrawValue();
	}

	@Override
	public double getAwayValue() {
		return distribution.getAwayValue();
	}

	@Override
	public void setHomeValue(double value) {
		distribution.setHomeValue(value);
	}

	@Override
	public void setDrawValue(double value) {
		distribution.setDrawValue(value);
	}

	@Override
	public void setAwayValue(double value) {
		distribution.setAwayValue(value);
	}


}
