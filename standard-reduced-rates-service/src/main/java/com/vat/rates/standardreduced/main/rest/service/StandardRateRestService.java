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
public class StandardRateRestService {

	@Autowired
	private CountriesRatesServiceProxy countriesRatesServiceProxy;

	@Value("${standard.rate.count}")
	private long STANDARD_RATE_COUNT;

	/**
	 * getHighestThreeCountriesStandardRates() method is used to load rates JSON
	 * data by injecting rate service proxy interface and apply the filter to get
	 * top three countries with highest standard rates
	 * 
	 * @return List<CountryRateDTO>
	 */
	public List<CountryRateDTO> getHighestThreeCountriesStandardRates() {

		var countriesRates = countriesRatesServiceProxy.loadRatesJsonData();

		if (!CollectionUtils.isEmpty(countriesRates)) {
			var countryList = countriesRatesServiceProxy.loadRatesJsonData().stream()
					.sorted(Comparator.comparing(CountriesRates::standard_rate).reversed()).limit(STANDARD_RATE_COUNT)
					.map(cr -> new CountryRateDTO(cr.country(), cr.standard_rate())).toList();

			return countryList;
		} else {
			return (new ArrayList<>());
		}
	}
}