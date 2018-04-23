package com.magneto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.magneto.dao.DnaRepository;
import com.magneto.model.Dna;
import com.magneto.model.Statistic;
import com.magneto.service.MutantStatsService;

@Component
public class MutantStatsServiceImpl implements MutantStatsService {
	
	@Autowired
	private DnaRepository dnaDAO;

	@Override
	public Statistic getMutantStatistics() {
		
		long totalDnaAnalysedCount = dnaDAO.count();
		long mutantDnaCount = dnaDAO.count(getMutantExample());
		
		return new Statistic(mutantDnaCount,totalDnaAnalysedCount - mutantDnaCount);
	}
	
	private Example<Dna> getMutantExample() {
		
		return Example.of(new Dna(null, true));
	}
	
}
