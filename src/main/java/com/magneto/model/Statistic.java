package com.magneto.model;

public class Statistic {
	
	private long countMutantDna;
	private long countHumanDna;
	private double ratio;

	public Statistic(long countMutantDna, long countHumanDna) {
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
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
	
	public double getRatio() {
		
		if (countHumanDna > 0 && countMutantDna > 0) {
			return ((double) countMutantDna/countHumanDna); 
		} else if (countHumanDna==0) { 
			return countMutantDna;
		} 
		return 0;
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
