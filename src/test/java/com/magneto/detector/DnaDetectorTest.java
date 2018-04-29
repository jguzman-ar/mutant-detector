package com.magneto.detector;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DnaDetectorTest {
	
	private final List<String> mutantInputOneMatch = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
	private final List<String> mutantInputTwoMatches = Arrays.asList("ATGCGA", "CGGGGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
	private final List<String> nonMutantInput = Arrays.asList("ATGTGT","TAGTGC","TTATGT", "AGACGG", "GAGTCA","TCACTG");
	
	@Test
	public void isMutantDnaTest() {
		boolean output = DnaDetector.isMutantDna(mutantInputOneMatch);		
		assertTrue("It's a mutant!",output);
		
		output = DnaDetector.isMutantDna(mutantInputTwoMatches);
		assertTrue("It's a mutant!",output);
	}
	
	@Test
	public void isMutantDnaTestNonMutant() {
		boolean output = DnaDetector.isMutantDna(nonMutantInput);
		
		assertFalse("It's not a mutant!",output);
	}

}
