package com.magneto.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.magneto.model.Dna;

public interface PersistenceService {
	
	CompletableFuture<Dna> saveDna(List<String> dnaStrings, boolean isMutant) throws InterruptedException;
}