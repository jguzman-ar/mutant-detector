package com.magneto.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MutantDetectorServiceImpl implements MutantDetectorService {

	@Override
	public boolean isMutant(List<String> dnaStrings) {

		return false;
	}

}
