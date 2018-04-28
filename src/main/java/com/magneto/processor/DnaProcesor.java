package com.magneto.processor;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DnaProcesor {
	
	private static final Logger log = LoggerFactory.getLogger(DnaProcesor.class);

	public static List<String> buildVerticalDnaStrings(final List<String> dnaStrings) {

		List<String> verticalDnaString = new ArrayList<String>();

		// Vertical processing needs transposing the string arrays at char level by
		// position
		for (int rowArrange = 0; rowArrange < dnaStrings.size(); rowArrange++) {

			StringBuffer columnArrange = new StringBuffer(dnaStrings.size());

			for (int column = 0; column < dnaStrings.size(); column++) {

				columnArrange.append(dnaStrings.get(column).charAt(rowArrange));
			}
			verticalDnaString.add(columnArrange.toString());
		}

		log.info(String.format("Vertical array built %s", verticalDnaString.toString()));

		return verticalDnaString;
	}

	public static List<String> buildDiagonalDnaStringsTopBottom(final List<String> dnaStrings) {

		List<String> diagonalDnaString = new ArrayList<String>();

		// Diagonal processing orientation from top to bottom
		for (int i = 0; i < dnaStrings.size() / 2; i++) {

			StringBuffer diagonalArrangeUpper = new StringBuffer(dnaStrings.size());
			StringBuffer diagonalArrangeLower = new StringBuffer(dnaStrings.size());

			for (int j = 0; j < dnaStrings.size() - i; j++) {
				diagonalArrangeUpper.append(dnaStrings.get(j).charAt(j + i));

				if (i != 0) {
					diagonalArrangeLower.append(dnaStrings.get(i + j).charAt(j));
				}
			}

			if (diagonalArrangeUpper.length() > 0) {
				diagonalDnaString.add(diagonalArrangeUpper.toString());
			}

			if (diagonalArrangeLower.length() > 0) {
				diagonalDnaString.add(diagonalArrangeLower.toString());
			}
		}

		log.info(String.format("Diagonal array built from top to bottom %s", diagonalDnaString.toString()));

		return diagonalDnaString;
	}

	public static List<String> buildDiagonalDnaStringsBottomTop(final List<String> dnaStrings) {

		List<String> diagonalDnaString = new ArrayList<String>();

		// Diagonal processing orientation from bottom to top
		for (int i = 0; i < dnaStrings.size() / 2; i++) {

			StringBuffer diagonalArrangeUpper = new StringBuffer(dnaStrings.size());
			StringBuffer diagonalArrangeLower = new StringBuffer(dnaStrings.size());

			for (int j = dnaStrings.size() - 1; j >= i; j--) {
				diagonalArrangeUpper.append(dnaStrings.get(j).charAt(i + dnaStrings.size() - 1 - j));

				if (i != 0) {
					diagonalArrangeLower.append(dnaStrings.get(j - i).charAt(dnaStrings.size() - 1 - j));
				}
			}

			if (diagonalArrangeUpper.length() > 0) {
				diagonalDnaString.add(diagonalArrangeUpper.toString());
			}

			if (diagonalArrangeLower.length() > 0) {
				diagonalDnaString.add(diagonalArrangeLower.toString());
			}
		}
		log.info(String.format("Diagonal array built from bottom to top %s", diagonalDnaString.toString()));

		return diagonalDnaString;
	}

}
