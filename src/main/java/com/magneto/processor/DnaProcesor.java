package com.magneto.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DnaProcesor {
	
	private static final Predicate<String> StringPredicateA = s -> s.contains("AAAA");
	private static final Predicate<String> StringPredicateC = s -> s.contains("CCCC");
	private static final Predicate<String> StringPredicateG = s -> s.contains("GGGG");
	private static final Predicate<String> StringPredicateT = s -> s.contains("TTTT");
	private static final Predicate<String> mutantDnaPredicate = StringPredicateA.or(StringPredicateC).or(StringPredicateG).or(StringPredicateT);
	
	public static void buildDnaStrings(final List<String> dnaStrings) {
		 				
		// Horizontal processing don't need any special treatment
		//List<String> filteredMutants = dnaStrings.stream().filter(mutantDnaPredicate).collect(Collectors.toList());
		List<String> filteredMutants = new ArrayList<String>();		
		
		//buildVerticalDnaStrings(dnaStrings, filteredMutants);
		
		buildObliqueDnaStringsTopBottom(dnaStrings, filteredMutants);
		
		System.out.println(filteredMutants.size());

	}

	private static void buildVerticalDnaStrings(final List<String> dnaStrings, List<String> filteredMutants) {
		
		// Vertical processing needs transposing the string arrays at char level by position
		for(int rowArrange = 0; rowArrange < dnaStrings.size(); rowArrange++) {

            StringBuffer columnArrange = new StringBuffer(dnaStrings.size());

            for (int column = 0; column < dnaStrings.size(); column++) {
            	
            	columnArrange.append(dnaStrings.get(column).charAt(rowArrange));
            }
            filteredMutants.add(columnArrange.toString());
        }
		
		System.out.println("Vertical array built" + filteredMutants.toString());
	}
	
	
	private static void buildObliqueDnaStringsTopBottom(final List<String> dnaStrings, List<String> filteredMutants) {
		
	    for(int i = 0; i < dnaStrings.size() / 2; i++) {
	    	
            StringBuffer obliqueArrange1 = new StringBuffer(dnaStrings.size());
            StringBuffer obliqueArrange2 = new StringBuffer(dnaStrings.size());

            for (int j = 0; j < dnaStrings.size() -i; j++) {
            	obliqueArrange1.append(dnaStrings.get(j).charAt(j+i));

                if(i != 0) {
                	obliqueArrange2.append(dnaStrings.get(i + j).charAt(j));
                }
            }

            if(obliqueArrange1.length() > 0) {
            	filteredMutants.add(obliqueArrange1.toString());
            }

            if(obliqueArrange2.length() > 0) {
            	filteredMutants.add(obliqueArrange2.toString());
            }
        }
	    
	    System.out.println("Oblique array built top to bottom" + filteredMutants.toString());
		
	}

}
