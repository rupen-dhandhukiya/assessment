package com.vat.rates.standardreduced.main.rest.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vat.rates.standardreduced.main.dto.CountryRateDTO;
import com.vat.rates.standardreduced.main.model.CountriesRates;

@Service
public class ReducedRateRestService {

	@Autowired
	private CountriesRatesServiceProxy countriesRatesServiceProxy;

	@Value("${reduced.rate.count}")
	private long REDUCED_RATE_COUNT;

	/**
	 * getLowestThreeCountriesReducedRates() method is used to load rates json data
	 * by injecting rate service proxy interface and apply the filter to get last
	 * three countries with lowest reduced rates
	 * 
	 * @return List<CountryRateDTO>
	 */
	public List<CountryRateDTO> getLowestThreeCountriesReducedRates() {

		var countriesRates = countriesRatesServiceProxy.loadRatesJsonData();

		if (!CollectionUtils.isEmpty(countriesRates)) {
			var countryList = countriesRates.stream().sorted(Comparator.comparing(CountriesRates::reduced_rate))
					.limit(REDUCED_RATE_COUNT).map(cr -> new CountryRateDTO(cr.country(), cr.reduced_rate())).toList();

			return countryList;
		} else {
			return new ArrayList<>();
		}
	}
}