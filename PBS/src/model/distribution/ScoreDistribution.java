package model.distribution;

import container.ScoreContainer;

public class ScoreDistribution extends Distribution implements ScoreContainer {
	
	public static enum ScoreChoice {
		UNDER,
		OVER
	}

	
	private double under;
	private double over;
	
	
	@Override
	public int getSize() {
		return 2;
	}


	@Override
	public double getUnderValue() {
		return under;
	}

	@Override
	public double getOverValue() {
		return over;
	}

	@Override
	public void setUnderValue(int value) {
		this.under = value;
	}

	@Override
	public void setOverValue(int value) {
		this.over = value;
	}


	@Override
	public boolean isSumOne() {
		return under + over == 1;
	}

}
