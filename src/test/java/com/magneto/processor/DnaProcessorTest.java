package com.magneto.processor;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DnaProcessorTest {
	
	private final List<String> verticalInput = Arrays.asList("ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG");
	private final List<String> verticalOutput = Arrays.asList("ACTACT", "TATGCC", "GGAACA", "CTTACC", "GGGGTT", "ACTGAG");
	private final List<String> diagonalInputTB = Arrays.asList("ATGTGT","TAGTGC","TTATGT", "AGACGG", "GAGTCA","TCACTG");	
	private final List<String> diagonalOutputTB = Arrays.asList("AAACCG", "TGTGA", "TTATT", "GTGG", "TGGC");
	private final List<String> diagonalOutputBT = Arrays.asList("TAATGT", "CGCGC", "GGATG", "ATGT", "ATGT");
	
	@Test
	public void testBuildVerticalDnaStrings() {
		
		List<String> output = DnaProcessor.buildVerticalDnaStrings(verticalInput);
		
		Assert.assertTrue(output.size() == verticalOutput.size());
		Assert.assertEquals(verticalOutput, output);
	}
	
	@Test
	public void testBuildDiagonalDnaStringsTopBottom() {
		
		List<String> output = DnaProcessor.buildDiagonalDnaStringsTopBottom(diagonalInputTB);
		
		Assert.assertTrue(output.size() == diagonalOutputTB.size());
		Assert.assertEquals(diagonalOutputTB, output);
	}
	
	@Test
	public void testBuildDiagonalDnaStringsBottomTop() {
		
		List<String> output = DnaProcessor.buildDiagonalDnaStringsBottomTop(diagonalInputTB);
		
		Assert.assertTrue(output.size() == diagonalOutputBT.size());
		Assert.assertEquals(diagonalOutputBT, output);
	}
	
}