package com.vat.rates.main.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RateControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@Test
	public void loadDataFromExternalServiceTest() throws Exception {
		mockMvc.perform(get("/rates_microservice/vat/rates")).andExpect(status().isOk());
	}
}
