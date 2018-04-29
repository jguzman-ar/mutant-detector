package com.magneto.detector;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.magneto.processor.DnaProcessor;

public class DnaDetector {
	
	private static final Predicate<String> DNA_PREDICATE_A = s -> s.contains("AAAA");
	private static final Predicate<String> DNA_PREDICATE_C = s -> s.contains("CCCC");
	private static final Predicate<String> DNA_PREDICATE_G = s -> s.contains("GGGG");
	private static final Predicate<String> DNA_PREDICATE_T = s -> s.contains("TTTT");
	private static final Predicate<String> MUTANT_DNA_PREDICATE = DNA_PREDICATE_A.or(DNA_PREDICATE_C).or(DNA_PREDICATE_G).or(DNA_PREDICATE_T);
	
    /** 
     * Analyzes and determine presence of mutant DNA via building strings in different orientations
     * to determine if partial matchings already fulfill the mutant criteria at every step saving some 
     * clock ticks.
     * 
     * @param dnaStrings 
     * @return whether passed in dna strings match with mutant dna.
     */
	public static boolean isMutantDna(final List<String> dnaStrings) {
		
		int foundMutantDnaCount = 0;
		
		// Horizontal processing don't need any special treatment
		foundMutantDnaCount = dnaStrings.stream().filter(MUTANT_DNA_PREDICATE).collect(Collectors.toList()).size();		
		if (foundMutantDnaCount >1) return true;
		
		// Vertical processing 
		foundMutantDnaCount += DnaProcessor.buildVerticalDnaStrings(dnaStrings).stream().filter(MUTANT_DNA_PREDICATE).collect(Collectors.toList()).size();
		if (foundMutantDnaCount >1) return true;
		
		//Diagonal processing top to bottom
		foundMutantDnaCount += DnaProcessor.buildDiagonalDnaStringsTopBottom(dnaStrings).stream().filter(MUTANT_DNA_PREDICATE).collect(Collectors.toList()).size();
		if (foundMutantDnaCount >1) return true;
		
		//Diagonal processing bottom to top
		foundMutantDnaCount += DnaProcessor.buildDiagonalDnaStringsBottomTop(dnaStrings).stream().filter(MUTANT_DNA_PREDICATE).collect(Collectors.toList()).size();
		if (foundMutantDnaCount >1) return true;
		
		return false;
			
	}

}
