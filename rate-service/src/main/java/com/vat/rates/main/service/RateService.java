package com.vat.rates.main.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vat.rates.main.model.CountryRates;

@Service
public class RateService {

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

	public List<CountryRates> loadCountryRatesData() {

		var countryRateList = new ArrayList<CountryRates>();

		JsonNode jsonResponse = rateServiceProxy.loadRatesJsonData();

		if (jsonResponse != null) {
			JsonNode jsonRatesList = jsonResponse.get(RATES);
			
			if (jsonRatesList != null) {
				Iterator<Map.Entry<String, JsonNode>> fields = jsonRatesList.fields();

				if (fields != null) {
					while (fields.hasNext()) {
						Map.Entry<String, JsonNode> field = fields.next();

						String country = field.getValue().get(COUNTRY).asText();
						double standardRate = field.getValue().get(STANDARD_RATE).doubleValue();
						double reducedRate = field.getValue().get(REDUCED_RATE).doubleValue();

						CountryRates countryRates = new CountryRates(country, standardRate, reducedRate);
						countryRateList.add(countryRates);
					}
				}
			}
		}
		return countryRateList;
	}
}