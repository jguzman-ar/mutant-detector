package com.magneto.service.mapper;

import com.magneto.model.Statistic;
import com.magneto.webservice.resource.StatsResource;

public class StatisticsMapper {
	
	public static StatsResource map(Statistic statistic) {
		
		return new StatsResource(statistic.getCountMutantDna(), statistic.getCountHumanDna(), statistic.getRatio());
	}
	
}
