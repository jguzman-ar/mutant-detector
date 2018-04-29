package com.magneto.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.magneto.dao.DnaRepository;
import com.magneto.exception.PersistenceException;
import com.magneto.model.Dna;
import com.magneto.model.Statistic;
import com.magneto.service.MutantStatsService;

@Service
public class MutantStatsServiceImpl implements MutantStatsService {

	private static final Logger log = LoggerFactory.getLogger(MutantDetectorServiceImpl.class);

	@Autowired
	private DnaRepository dnaDAO;

	@Override
	public Statistic getMutantStatistics() {
		
		long totalDnaAnalysedCount=0;
		long mutantDnaCount=0;

		try {
			totalDnaAnalysedCount = dnaDAO.count();
			mutantDnaCount = dnaDAO.count(getMutantExample());
		} catch (PersistenceException pe) {
			log.error(String.format("An error occurred while accessing the data store", pe.getMessage()));
		}

		log.info("Retrieving stats information");
		return new Statistic(mutantDnaCount, totalDnaAnalysedCount - mutantDnaCount);
	}

	private Example<Dna> getMutantExample() {

		return Example.of(new Dna(null, true));
	}

	public void setDnaDAO(DnaRepository dnaDAO) {
		this.dnaDAO = dnaDAO;
	}


}
