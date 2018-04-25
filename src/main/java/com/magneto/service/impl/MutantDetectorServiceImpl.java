package com.magneto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magneto.detector.DnaDetector;
import com.magneto.service.MutantDetectorService;
import com.magneto.service.PersistenceService;

@Service
public class MutantDetectorServiceImpl implements MutantDetectorService {
	
	@Autowired
	PersistenceService persistenceService;
	
	@Override
	public boolean isMutant(final List<String> dnaStrings) {
		
		boolean isMutant = DnaDetector.isMutantDna(dnaStrings); 
		
		try {
			persistenceService.saveDna(dnaStrings, isMutant);
			
		} catch (InterruptedException e) {
			System.out.println("Exception caught while persisting data asynchronously");
		}		
		return isMutant;
	}

}
