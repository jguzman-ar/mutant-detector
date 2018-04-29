package com.magneto.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import com.magneto.MagnetoTest;
import com.magneto.dao.DnaRepository;
import com.magneto.exception.PersistenceException;
import com.magneto.model.Statistic;

public class MutantStatsServiceImplTest extends MagnetoTest {
	
	@Mock
	DnaRepository dnaDao;
	
	MutantStatsServiceImpl mssi = new MutantStatsServiceImpl();
	
	@Before
	public void setup() {
		mssi.setDnaDAO(dnaDao);
	}

	@Test
	public void getMutantStatisticsTest() {
				
		//total dna count
		when(dnaDao.count()).thenReturn(110L);
		// mutant dna count
		when(dnaDao.count(any())).thenReturn(10L);
		
		Statistic output = mssi.getMutantStatistics(); 
		
		Assert.assertTrue(output.getCountHumanDna() == 100);
		Assert.assertTrue(output.getCountMutantDna() == 10);
		Assert.assertTrue(output.getRatio() == 0.1);
		
		verify(dnaDao,times(1)).count();
		verify(dnaDao,times(1)).count(any());
		
	}

	
	@Test
	public void getMutantStatisticsTestPersistenceException() {
				
		when(dnaDao.count()).thenThrow(PersistenceException.class);
		
		mssi.getMutantStatistics(); 
						
		verify(dnaDao,times(1)).count();
		
	}
}
