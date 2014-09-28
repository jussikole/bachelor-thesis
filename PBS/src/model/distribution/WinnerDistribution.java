package model.distribution;

import container.WinnerContainer;

public class WinnerDistribution extends Distribution implements WinnerContainer {
	
	private double home;
	private double draw;
	private double away;
	
	
	public WinnerDistribution() {
		
	}
	
	@Override
	public int getSize() {
		return 3;
	}


	@Override
	public double getHomeValue() {
		return home;
	}

	@Override
	public double getDrawValue() {
		return draw;
	}

	@Override
	public double getAwayValue() {
		return away;
	}

	@Override
	public void setHomeValue(double value) {
		this.home = value;
	}

	@Override
	public void setDrawValue(double value) {
		this.draw = value;
	}

	@Override
	public void setAwayValue(double value) {
		this.away = value;
	}

	@Override
	public boolean isSumOne() {
		return home + draw + away == 1;
	}
	
}
