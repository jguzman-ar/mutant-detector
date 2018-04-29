package com.magneto.model;

public class Statistic {
	
	private long countMutantDna;
	private long countHumanDna;

	public Statistic(long countMutantDna, long countHumanDna) {
		this.countMutantDna = countMutantDna;
		this.countHumanDna = countHumanDna;
	}

	public long getCountMutantDna() {
		return countMutantDna;
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

}
