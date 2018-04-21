package com.magneto.webservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.webservice.resource.StatsResource;

@RestController
public class StatsController {
	
	@RequestMapping(value="/stats", method = RequestMethod.GET, produces = "application/json")
	StatsResource getMutantStatistics() {
		return new StatsResource(10, 5, 2);
	}

}
