package com.magneto.model;

public class Statistic {
	
	private long countMutantDna;
	private long countHumanDna;
	private double ratio;

	public Statistic(long countMutantDna, long countHumanDna, double ratio) {
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
		this.ratio = ratio;
	}

	public long getCountMutantDna() {
		return countMutantDna;
	}
	
	public void setCountMutantDna(Long countMutantDna) {
		this.countMutantDna = countMutantDna;
	}
	
	public long getCountHumanDna() {
		return countHumanDna;
	}
	
	public void setCountHumanDna(Long countHumanDna) {
		this.countHumanDna = countHumanDna;
	}
	
	public double getRatio() {
		return ratio;
	}
	
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	
	@Override
	public String toString() {
		return "Statistic [countMutantDna=" + countMutantDna + ", countHumanDna=" + countHumanDna + ", ratio=" + ratio
				+ "]";
	}

}
