package model.bet;

public class Kelly implements BetSizeRule {
	@Override
	public double calculate(double prob, double coef) {
		return (prob * coef - 1) / (coef - 1);
	}
}
