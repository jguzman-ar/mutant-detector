package com.magneto.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.magneto.detector.DnaDetector;
import com.magneto.service.MutantDetectorService;

@Component
public class MutantDetectorServiceImpl implements MutantDetectorService {

	@Override
	public boolean isMutant(List<String> dnaStrings) {
		
		return DnaDetector.isMutantDna(dnaStrings);
	}

}
