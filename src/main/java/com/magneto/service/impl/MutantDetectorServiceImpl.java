package com.magneto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magneto.detector.DnaDetector;
import com.magneto.exception.PersistenceException;
import com.magneto.service.MutantDetectorService;
import com.magneto.service.PersistenceService;

@Service
public class MutantDetectorServiceImpl implements MutantDetectorService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	PersistenceService persistenceService;

	@Override
	public boolean isMutant(final List<String> dnaStrings) {

		boolean isMutant = DnaDetector.isMutantDna(dnaStrings);

		try {
			persistenceService.saveDna(dnaStrings, isMutant);
		} catch (InterruptedException ie) {
			log.error(String.format("Error occurred while executing async saving in thread %s", Thread.currentThread()));
		}

		return isMutant;
	}

}
