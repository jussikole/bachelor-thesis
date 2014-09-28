package model.poisson;

import model.Model;

import org.apache.commons.math.distribution.PoissonDistribution;
import org.apache.commons.math.distribution.PoissonDistributionImpl;


public class MoroneyModel extends Model {

	public MoroneyModel() {
		super();
	}

	

	@Override
	public ModelType getModelType() {
		return ModelType.MORONEY;
	}

	@Override
	public String toString() {
		return "Moroney";
	}


}
