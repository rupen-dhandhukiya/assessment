package com.vat.rates.standardreduced.main.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vat.rates.standardreduced.main.dto.CountryRateDTO;
import com.vat.rates.standardreduced.main.rest.service.StandardRateRestService;

@RestController
@RequestMapping("${application.path}")
public class StandardRateRestController {

	@Autowired
	private StandardRateRestService standardRateRestService;

	/**
	 * getHighestThreeCountriesStandardRates() method is used to load rates JSON
	 * data by injecting rate service proxy interface and apply the filter to get
	 * top three countries with highest standard rates
	 * 
	 * @return List<CountryRateDTO>
	 */
	@GetMapping(path = "${standard.rate.path}")
	public ResponseEntity<List<CountryRateDTO>> getHighestThreeCountriesStandardRates() {

		var countryList = standardRateRestService.getHighestThreeCountriesStandardRates();

		return ResponseEntity.ok(countryList);
	}
}