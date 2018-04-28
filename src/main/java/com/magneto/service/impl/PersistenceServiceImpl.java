package com.magneto.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.magneto.dao.DnaRepository;
import com.magneto.exception.PersistenceException;
import com.magneto.model.Dna;
import com.magneto.service.PersistenceService;

@Service
public class PersistenceServiceImpl implements PersistenceService {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DnaRepository dnaDAO;
	
	@Async
    public CompletableFuture<Dna> saveDna(List<String> dnaStrings, boolean isMutant) {
		
		Dna dnaResult = null;
		
		try {
			dnaResult = dnaDAO.save(new Dna(composeIdFromDna(dnaStrings), isMutant));		
		} catch (PersistenceException pe) {
			log.error(String.format("An error occurred while accessing the data store. Dna processed but not persisted is %s ", dnaStrings));
		}
		
		log.info(String.format("Saved Dna: %s using async thread: %s", dnaStrings,Thread.currentThread()));
		
		return CompletableFuture.completedFuture(dnaResult);		
	}

	private String composeIdFromDna(List<String> dnaList) {		
		return dnaList.stream().collect(Collectors.joining(""));
	}
}
