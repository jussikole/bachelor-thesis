package bet.result;

import java.util.ArrayList;

import javax.persistence.Transient;

import container.ResultContainer;
import model.distribution.ResultDistribution;
import sport.GameNotPlayedException;
import bet.Odds;

public class ResultOdds extends Odds implements ResultContainer {
	
	private ArrayList<ResultOddRow> rows;
	
	public ResultOdds() {
		super();
		this.rows = new ArrayList<ResultOddRow>();
	}

	@Transient
	@Override
	public double getScoreValue(int index1, int index2) {
		return rows.get(index1).getValues().get(index2).getOdd();
	}
	@Override
	public void setScoreValue(int index1, int index2, double value) {
		rows.get(index1).getValues().get(index2).setOdd(value);
	}

}
