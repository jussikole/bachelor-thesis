package model.distribution;

public abstract class DistributionSource<D extends Distribution> {
	
	public abstract String getName();
	public abstract D getDistribution();
	
}
