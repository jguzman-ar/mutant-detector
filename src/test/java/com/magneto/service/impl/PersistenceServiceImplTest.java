package com.magneto.service.impl;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import com.magneto.MagnetoTest;
import com.magneto.dao.DnaRepository;
import com.magneto.exception.PersistenceException;
import com.magneto.model.Dna;

public class PersistenceServiceImplTest extends MagnetoTest {
	
	private final String testDnaId = "ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG";
	private final List<String> testDna = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
	
	@Mock
	DnaRepository dnaDao;
	
	PersistenceServiceImpl psi = new PersistenceServiceImpl();
	
	@Before
	public void setup() {
		psi.setDnaDAO(dnaDao);
	}
	
	@Test
	public void saveDnaTest() throws InterruptedException, ExecutionException {
		
		when(dnaDao.save(any())).thenReturn(new Dna(testDnaId, true));
		
		CompletableFuture<Dna> output = psi.saveDna(testDna, true);
		
		assertTrue(output.get().getDna().equals(testDnaId));
		assertTrue(output.get().isMutant());
		
		verify(dnaDao, times(1)).save(any());
	}
	
	@Test
	public void saveDnaTestPersistenceException() throws InterruptedException, ExecutionException {
		
		when(dnaDao.save(any())).thenThrow(PersistenceException.class);
		
		psi.saveDna(testDna, true);
		
		verify(dnaDao, times(1)).save(any());
	}

}
