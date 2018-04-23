package com.magneto.service;

import java.util.List;

public interface MutantDetectorService {
	
	boolean isMutant(List<String> dnaStrings);
}
