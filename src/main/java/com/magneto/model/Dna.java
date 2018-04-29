package com.magneto.model;

import org.springframework.data.annotation.Id;

public class Dna {

	@Id
	private String dna;
	private boolean isMutant;
	
	public String getDna() {
		return dna;
	}

	public Dna(String dna, boolean isMutant) {
		this.dna = dna;
		this.isMutant = isMutant;
	}

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
}


