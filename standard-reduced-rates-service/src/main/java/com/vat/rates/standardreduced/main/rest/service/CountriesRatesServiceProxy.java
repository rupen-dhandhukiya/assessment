package com.vat.rates.standardreduced.main.rest.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vat.rates.standardreduced.main.model.CountriesRates;

@FeignClient(name="${spring.application.name}", url="${rate.service.url}")
public interface CountriesRatesServiceProxy {
	
	@GetMapping
	List<CountriesRates> loadRatesJsonData();

}
