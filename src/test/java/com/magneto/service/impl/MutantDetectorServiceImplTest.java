package com.magneto.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import com.magneto.MagnetoTest;
import com.magneto.model.Dna;
import com.magneto.service.PersistenceService;

public class MutantDetectorServiceImplTest extends MagnetoTest {
	
	private final List<String> testDna = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");

	@Mock
	PersistenceService persistenceService;
	
	MutantDetectorServiceImpl mtsi = new MutantDetectorServiceImpl();
	
	@Before
	public void setup() {
		mtsi.setPersistenceService(persistenceService);
	}
	
	@Test
	public void isMutantTest() throws InterruptedException {

		when(persistenceService
				.saveDna(testDna, true))
				.thenReturn(CompletableFuture.completedFuture(mock(Dna.class)));
		
		Assert.assertTrue(mtsi.isMutant(testDna));				
		verify(persistenceService, atLeastOnce()).saveDna(testDna, true);
	}
	
	@Test
	public void isMutantTestInterruptedException() throws InterruptedException  {
		
		when(persistenceService
				.saveDna(testDna, true)).thenThrow(InterruptedException.class);
		
		Assert.assertTrue(mtsi.isMutant(testDna));				
		verify(persistenceService, atLeastOnce()).saveDna(testDna, true);
		
	}
	
	

}
