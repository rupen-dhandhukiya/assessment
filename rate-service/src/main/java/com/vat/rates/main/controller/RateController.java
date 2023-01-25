package com.vat.rates.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vat.rates.main.model.CountryRates;
import com.vat.rates.main.service.RateService;


@RestController
@RequestMapping("${application.path}")
public class RateController {
	
	@Autowired
	RateService rateService;

	/**
	 * loadRatesJsonData() call rateService and get data from the end point 
	 * 
	 * @return List<CountryRates> - list of countries and rates as ResponseEntity
	 */
	@GetMapping(path = "${rate.path}")
	public ResponseEntity<List<CountryRates>> loadRatesJsonData() {
		
		var countryRatesList = rateService.loadCountryRatesData();
		
		return ResponseEntity.ok(countryRatesList);
	}
}