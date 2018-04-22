package com.magneto.service.impl;

import org.springframework.stereotype.Component;

import com.magneto.model.Statistic;
import com.magneto.service.MutantStatsService;

@Component
public class MutantStatsServiceImpl implements MutantStatsService {

	@Override
	public Statistic getMutantStatistics() {
		return new Statistic(50, 100, 0.5);
	}

}
