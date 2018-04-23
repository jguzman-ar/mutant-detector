package com.magneto.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.magneto.dao.DnaRepository;
import com.magneto.detector.DnaDetector;
import com.magneto.model.Dna;
import com.magneto.service.MutantDetectorService;

@Component
public class MutantDetectorServiceImpl implements MutantDetectorService {
	
	@Autowired
	private DnaRepository dnaDAO;

	@Override
	public boolean isMutant(final List<String> dnaStrings) {
		
		boolean isMutant = DnaDetector.isMutantDna(dnaStrings); 
				
		dnaDAO.save(new Dna(composeIdFromDna(dnaStrings), isMutant));
		
		return isMutant;
	}

	private String composeIdFromDna(List<String> dnaList) {		
		return dnaList.stream().collect(Collectors.joining(""));
	};

}
