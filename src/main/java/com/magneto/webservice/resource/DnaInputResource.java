package com.magneto.webservice.resource;

import java.util.List;

public class DnaInputResource {

	List<String> dna;

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}

	@Override
	public String toString() {
		return "DnaInput [dna=" + dna + "]";
	}
}
