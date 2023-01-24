package com.vat.rates.main.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.vat.rates.main.model.CountryRates;
import com.vat.rates.main.service.RateServiceProxy;

@RestController
@RequestMapping("${application.path}")
public class RatesWebService {
	
	private static final Logger logger = LoggerFactory.getLogger(RatesWebService.class);

	@Value("${rates}")
	private String RATES;

	@Value("${country}")
	private String COUNTRY;

	@Value("${standard.rate}")
	private String STANDARD_RATE;

	@Value("${reduced.rate}")
	private String REDUCED_RATE;
	
	@Autowired
	RateServiceProxy rateServiceProxy;	

	/**
	 * loadRatesJsonData() method is used to load the entire json data by requesting endpoint service and 
	 * filters only countries and rates
	 * @return List<CountryRates> - list of countries and rates
	 */
	@GetMapping(path="${rate.path}")
	public ResponseEntity<List<CountryRates>> loadRatesJsonData() {
		logger.info("Entered inside loadRatesJsonData() method in RatesWebService");

			var countryRatesList = new ArrayList<CountryRates>();

	        JsonNode jsonResponse = rateServiceProxy.loadRatesJsonData();
	        JsonNode jsonRatesList = jsonResponse.get(RATES);

	        Iterator<Map.Entry<String, JsonNode>> fields = jsonRatesList.fields();
	        while (fields.hasNext()) {
	            Map.Entry<String, JsonNode> field = fields.next();
	            CountryRates countryRates = new CountryRates();
	            countryRates.setCountry(field.getValue().get(COUNTRY).toString());
	            countryRates.setStandard_rate(field.getValue().get(STANDARD_RATE).doubleValue());
	            countryRates.setReduced_rate(field.getValue().get(REDUCED_RATE).doubleValue());
	            countryRatesList.add(countryRates);
	        }
			logger.info("Ended inside loadRatesJsonData() method in RatesWebService");

	        return ResponseEntity.ok(countryRatesList);
		}
}
