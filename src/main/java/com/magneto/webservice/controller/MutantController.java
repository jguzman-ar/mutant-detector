package com.magneto.webservice.controller;

import javax.ws.rs.core.MediaType;

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
	
	@RequestMapping(value="/mutant", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	ResponseEntity<HttpStatus> isMutant(@RequestBody DnaInputResource dna) {

		return mutantDetector.isMutant(dna.getDna())? ResponseEntity.ok(HttpStatus.OK): ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}	
}
