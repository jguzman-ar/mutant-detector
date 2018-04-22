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
		
		//buildDiagonalDnaStringsTopBottom(dnaStrings, filteredMutants);
		
		buildDiagonalDnaStringsBottomToTop(dnaStrings, filteredMutants);
		
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
	
	
	private static void buildDiagonalDnaStringsTopBottom(final List<String> dnaStrings, List<String> filteredMutants) {
		
		// Diagonal processing orientation from top to bottom
	    for(int i = 0; i < dnaStrings.size() / 2; i++) {
	    	
            StringBuffer diagonalArrangeUpper = new StringBuffer(dnaStrings.size());
            StringBuffer diagonalArrangeLower = new StringBuffer(dnaStrings.size());

            for (int j = 0; j < dnaStrings.size() -i; j++) {
            	diagonalArrangeUpper.append(dnaStrings.get(j).charAt(j+i));

                if(i != 0) {
                	diagonalArrangeLower.append(dnaStrings.get(i+j).charAt(j));
                }
            }

            if(diagonalArrangeUpper.length() > 0) {
            	filteredMutants.add(diagonalArrangeUpper.toString());
            }

            if(diagonalArrangeLower.length() > 0) {
            	filteredMutants.add(diagonalArrangeLower.toString());
            }
        }
	    
	    System.out.println("Diagonal array built from top to bottom" + filteredMutants.toString());		
	}
	
	private static void buildDiagonalDnaStringsBottomToTop(final List<String> dnaStrings, List<String> filteredMutants) {
		
		// Diagonal processing orientation from bottom to top
	    for(int i = 0; i < dnaStrings.size() / 2; i++) {
	    	
            StringBuffer diagonalArrangeUpper = new StringBuffer(dnaStrings.size());
            StringBuffer diagonalArrangeLower = new StringBuffer(dnaStrings.size());

            for (int j = dnaStrings.size()-1; j >= i; j--) {
            	diagonalArrangeUpper.append(dnaStrings.get(j).charAt(i+dnaStrings.size()-1-j));

                if(i != 0) {
                	diagonalArrangeLower.append(dnaStrings.get(j-i).charAt(dnaStrings.size()-1-j));
                }
            }

            if(diagonalArrangeUpper.length() > 0) {
            	filteredMutants.add(diagonalArrangeUpper.toString());
            }

            if(diagonalArrangeLower.length() > 0) {
            	filteredMutants.add(diagonalArrangeLower.toString());
            }
        }
	    System.out.println("Diagonal array built from bottom to top" + filteredMutants.toString());		    
	}
	
}
