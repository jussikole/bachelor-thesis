package model;

import model.poisson.DixonColesModel;
import model.poisson.MaherModel;
import model.poisson.MoroneyModel;


public abstract class Model {
	public static enum ModelType {
		MAHER,
		DIXONCOLES,
		MORONEY
	}
	
	public Model() {

	}
	
	public abstract ModelType getModelType();
	public abstract String toString();
	
	public static Model getModel(ModelType modelType) {
		switch (modelType) {
		case DIXONCOLES: return new DixonColesModel();
		case MAHER: return new MaherModel();
		case MORONEY: return new MoroneyModel();
		default: return null;
		}
	}
}
