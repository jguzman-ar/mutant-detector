package com.magneto.webservice.controller;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static  org.mockito.Mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.magneto.MagnetoTest;
import com.magneto.service.MutantDetectorService;
import com.magneto.webservice.resource.DnaInputResource;


public class MutantControllerTest extends MagnetoTest {
	
	private final List<String> testDnaMutant = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
	private final List<String> testDnaHuman = Arrays.asList("ATGTGT","TAGTGC","TTATGT", "AGACGG", "GAGTCA","TCACTG");
	
	@Mock
	MutantDetectorService mutantDetector;
	
	MutantController mc = new MutantController();
	
	@Before
	public void setup() {
		mc.setMutantDetector(mutantDetector);
	}

	@Test
	public void isMutantTest() {
		DnaInputResource input = new DnaInputResource();
		input.setDna(testDnaMutant);
		
		when(mutantDetector.isMutant(testDnaMutant)).thenReturn(true);
		
		ResponseEntity<HttpStatus> output = mc.isMutant(input);
		
		Assert.assertTrue(output.getStatusCode() == HttpStatus.OK);
		
		verify(mutantDetector, times(1)).isMutant(testDnaMutant);
	}
	
	
	@Test
	public void isMutantTestHuman() {
		DnaInputResource input = new DnaInputResource();
		input.setDna(testDnaHuman);
		
		when(mutantDetector.isMutant(testDnaMutant)).thenReturn(false);
		
		ResponseEntity<HttpStatus> output = mc.isMutant(input);
		
		Assert.assertTrue(output.getStatusCode() == HttpStatus.FORBIDDEN);
		
		verify(mutantDetector, times(1)).isMutant(testDnaHuman);
	}
	
}
