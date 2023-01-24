package com.vat.rates.standardreduced.main.rest.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vat.rates.standardreduced.main.dto.CountryRateDTO;
import com.vat.rates.standardreduced.main.model.CountriesRates;
import com.vat.rates.standardreduced.main.rest.service.CountriesRatesServiceProxy;

@RestController
@RequestMapping("${application.path}")
public class ReducedRateRestService {
	
private static final Logger logger = LoggerFactory.getLogger(ReducedRateRestService.class);
	
	@Autowired
	private CountriesRatesServiceProxy countriesRatesServiceProxy;

	@Value("${reduced.rate.count}")
	private long REDUCED_RATE_COUNT;
	
	/**
	 * getHighestThreeCountriesStandardRates() method is used to load rates json data by injecting rate service proxy interface
	 * and apply the filter to get top three countries with highest standard rates
	 * @return JSONObject
	 */
	@GetMapping(path="${reduced.rate.path}")
	public ResponseEntity<List<CountryRateDTO>> getLowestThreeCountriesReducedRates() {
		logger.info("Entered inside getLowestThreeCountriesReducedRates() method in ReducedRateRestService");

			var countriesRates =countriesRatesServiceProxy.loadRatesJsonData();
			
			if(!CollectionUtils.isEmpty(countriesRates))
			{
				 var countryList =  countriesRatesServiceProxy.loadRatesJsonData().stream()
							.sorted(Comparator.comparing(CountriesRates::reduced_rate))
							.limit(REDUCED_RATE_COUNT)
							.map(cr -> new CountryRateDTO(cr.country(), cr.reduced_rate()))
							.collect(Collectors.toList());
				 
				 return ResponseEntity.ok(countryList);
			} else {
				return ResponseEntity.ok(null);
			}
		
	}
}

