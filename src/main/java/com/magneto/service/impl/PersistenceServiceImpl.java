package com.magneto.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.magneto.dao.DnaRepository;
import com.magneto.model.Dna;
import com.magneto.service.PersistenceService;

@Service
public class PersistenceServiceImpl implements PersistenceService {
	
	@Autowired
	private DnaRepository dnaDAO;
	
	@Async
    public CompletableFuture<Dna> saveDna(List<String> dnaStrings, boolean isMutant) throws InterruptedException {
		
		Dna dnaResult = dnaDAO.save(new Dna(composeIdFromDna(dnaStrings), isMutant));
		
		System.out.println("Saving thread - "+Thread.currentThread().toString());
		
		return CompletableFuture.completedFuture(dnaResult);		
	}

	private String composeIdFromDna(List<String> dnaList) {		
		return dnaList.stream().collect(Collectors.joining(""));
	}
}
