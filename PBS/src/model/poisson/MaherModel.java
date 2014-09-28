package model.poisson;

import model.Model;



public class MaherModel extends Model {

	public MaherModel() {
		super();
	}

	@Override
	public ModelType getModelType() {
		return ModelType.MAHER;
	}

	@Override
	public String toString() {
		return "Maher";
	}


}
