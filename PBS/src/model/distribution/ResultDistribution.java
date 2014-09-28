package model.distribution;

import container.ResultContainer;

public class ResultDistribution extends Distribution implements ResultContainer {
	public static final int MAX_GOALS = 9;
	
	private Double[][] values;
	private int maxGoals;
	
	public ResultDistribution() {
		this(MAX_GOALS);
	}
	
	public ResultDistribution(int maxGoals) {
		this.values = new Double[maxGoals+1][maxGoals+1];
	}

	@Override
	public int getSize() {
		return maxGoals + 1;
	}

	@Override
	public double getScoreValue(int index1, int index2) {
		return values[index1][index2];
	}

	@Override
	public void setScoreValue(int index1, int index2, double value) {
		this.values[index1][index2] = value;
	}
	
	public WinnerDistribution toWinnerDistribution() {
		WinnerDistribution winnerDist = new WinnerDistribution();
		
		for (int i=0; i<this.getSize(); i++) {
			for (int j=0; j<this.getSize(); j++) {
				if (i > j) {
					winnerDist.setHomeValue(winnerDist.getHomeValue() + this.getScoreValue(i, j));
				}
				else if (i == j) {
					winnerDist.setDrawValue(winnerDist.getDrawValue() + this.getScoreValue(i, j));
				}
				else {
					winnerDist.setAwayValue(winnerDist.getAwayValue() + this.getScoreValue(i, j));
				}
			}
		}
		
		return winnerDist;
	}

	@Override
	public boolean isSumOne() {
		double total = 0;
		for (int i=0; i<this.getSize(); i++) {
			for (int j=0; j<this.getSize(); j++) {
				total += this.getScoreValue(i, j);
			}
		}
		return total == 1.0;
	}
}
