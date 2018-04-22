package com.magneto.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.magneto.processor.DnaProcesor;
import com.magneto.service.MutantDetectorService;

@Component
public class MutantDetectorServiceImpl implements MutantDetectorService {

	@Override
	public boolean isMutant(List<String> dnaStrings) {
		
		DnaProcesor.buildDnaStrings(dnaStrings);
		
		return false;
	}

}
