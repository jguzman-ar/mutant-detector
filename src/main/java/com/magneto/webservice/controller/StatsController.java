package com.magneto.webservice.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.service.MutantStatsService;
import com.magneto.service.mapper.StatisticsMapper;
import com.magneto.webservice.resource.StatsResource;

@RestController
public class StatsController {
	
	@Autowired
	private MutantStatsService statistics;
	
	@RequestMapping(value="/stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	StatsResource getMutantStatistics() {
		
		return StatisticsMapper.map(statistics.getMutantStatistics());
	}

}
