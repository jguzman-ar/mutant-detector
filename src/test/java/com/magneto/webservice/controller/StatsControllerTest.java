package com.magneto.webservice.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import com.magneto.MagnetoTest;
import com.magneto.model.Statistic;
import com.magneto.service.MutantStatsService;
import com.magneto.webservice.resource.StatsResource;

public class StatsControllerTest extends MagnetoTest {
	
	@Mock
	MutantStatsService mutantStats;
	
	StatsController sc = new StatsController();
	
	@Before
	public void setup() {
		sc.setStatistics(mutantStats);
	}
	
	@Test
	public void getStatistics() {
		
		Statistic input = new Statistic(5, 100);
		
		when(mutantStats.getMutantStatistics()).thenReturn(input);
		
		StatsResource output = sc.getMutantStatistics();
		
		Assert.assertTrue(output.getCount_human_dna() == 100);
		Assert.assertTrue(output.getCount_mutant_dna() == 5);
		Assert.assertTrue(output.getRatio() == 0.05);
		
		verify(mutantStats, times(1)).getMutantStatistics();
		
	}

}
