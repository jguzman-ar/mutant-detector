package com.magneto.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.service.MutantDetectorService;
import com.magneto.webservice.resource.DnaInputResource;

@RestController
public class MutantController {
		
	@Autowired
	private MutantDetectorService mutantDetector;
	
	@RequestMapping(value="/mutant", method = RequestMethod.POST, produces = "application/json")
	ResponseEntity<HttpStatus> isMutant(@RequestBody DnaInputResource dna) {
		
		System.out.println(dna.toString());
		
		return mutantDetector.isMutant(dna.getDna())? ResponseEntity.ok(HttpStatus.OK): ResponseEntity.ok(HttpStatus.FORBIDDEN);
	}	
}
