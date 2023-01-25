package com.vat.rates.standardreduced.main.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vat.rates.standardreduced.main.dto.CountryRateDTO;
import com.vat.rates.standardreduced.main.rest.service.ReducedRateRestService;

@RestController
@RequestMapping("${application.path}")
public class ReducedRateRestController {

	@Autowired
	private ReducedRateRestService reducedRateRestService;

	@Value("${reduced.rate.count}")
	private long REDUCED_RATE_COUNT;

	/**
	 * getLowestThreeCountriesReducedRates() method is used to load rates json
	 * data by injecting rate service proxy interface and apply the filter to get
	 * bottom three countries with lowest reduced rates
	 * 
	 * @return List<CountryRateDTO>
	 */
	@GetMapping(path = "${reduced.rate.path}")
	public ResponseEntity<List<CountryRateDTO>> getLowestThreeCountriesReducedRates() {

		var countryList = reducedRateRestService.getLowestThreeCountriesReducedRates();

		return ResponseEntity.ok(countryList);
	}
}