package model.poisson;

import model.Model;


public class DixonColesModel extends Model {

	public DixonColesModel() {
		super();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.DIXONCOLES;
	}


	@Override
	public String toString() {
		return "Dixon Coles";
	}



}
