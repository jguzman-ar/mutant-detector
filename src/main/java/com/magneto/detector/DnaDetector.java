package com.magneto.detector;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.magneto.processor.DnaProcesor;

public class DnaDetector {
	
	private static final Predicate<String> StringPredicateA = s -> s.contains("AAAA");
	private static final Predicate<String> StringPredicateC = s -> s.contains("CCCC");
	private static final Predicate<String> StringPredicateG = s -> s.contains("GGGG");
	private static final Predicate<String> StringPredicateT = s -> s.contains("TTTT");
	private static final Predicate<String> mutantDnaPredicate = StringPredicateA.or(StringPredicateC).or(StringPredicateG).or(StringPredicateT);
	
    /** 
     * Analyzes and determine presence of mutant DNA building strings in different orientations
     * to determine if partial matchings already fulfill the mutant criteria at every step saving some 
     * clock ticks.
     * 
     * @param dnaStrings 
     * @return whether passed in dna strings match with mutant dna.
     */
	public static boolean isMutantDna(final List<String> dnaStrings) {
		
		int foundMutantDnaCount = 0;
		
		// Horizontal processing don't need any special treatment
		foundMutantDnaCount = dnaStrings.stream().filter(mutantDnaPredicate).collect(Collectors.toList()).size();		
		if (foundMutantDnaCount >1) return true;
		
		// Vertical processing 
		foundMutantDnaCount += DnaProcesor.buildVerticalDnaStrings(dnaStrings).stream().filter(mutantDnaPredicate).collect(Collectors.toList()).size();
		if (foundMutantDnaCount >1) return true;
		
		//Diagonal processing top to bottom
		foundMutantDnaCount += DnaProcesor.buildDiagonalDnaStringsTopBottom(dnaStrings).stream().filter(mutantDnaPredicate).collect(Collectors.toList()).size();
		if (foundMutantDnaCount >1) return true;
		
		//Diagonal processing bottom to top
		foundMutantDnaCount += DnaProcesor.buildDiagonalDnaStringsBottomTop(dnaStrings).stream().filter(mutantDnaPredicate).collect(Collectors.toList()).size();
		if (foundMutantDnaCount >1) return true;
		
		return false;
			
	}

}
