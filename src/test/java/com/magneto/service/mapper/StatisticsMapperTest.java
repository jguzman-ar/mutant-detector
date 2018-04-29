package com.magneto.service.mapper;

import org.junit.Assert;
import org.junit.Test;
import com.magneto.MagnetoTest;
import com.magneto.model.Statistic;
import com.magneto.webservice.resource.StatsResource;

public class StatisticsMapperTest extends MagnetoTest {
	
	@Test
	public void map() {
		
		Statistic stats = new Statistic(10, 100);
		
		StatsResource output = StatisticsMapper.map(stats);
		
		Assert.assertTrue(output.getCount_human_dna() == stats.getCountHumanDna());
		Assert.assertTrue(output.getCount_mutant_dna() == stats.getCountMutantDna());
		Assert.assertTrue(output.getRatio() == stats.getRatio());
		
	}

}
