package com.vat.rates.standardreduced.main.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ReducedRateRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getLowestThreeCountriesReducedRates() throws Exception {
		mockMvc.perform(get("/standard-reduced-rates-service/vat/rate/getStandardRates")).andExpect(status().isOk());
	}
}
