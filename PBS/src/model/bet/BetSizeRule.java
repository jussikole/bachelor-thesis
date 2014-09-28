package model.bet;

public interface BetSizeRule {
	public double calculate(double prob, double coef);
}
