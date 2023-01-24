package com.vat.rates.standardreduced.main.model;

public record CountriesRates (String country, double standard_rate, double reduced_rate) {}


//public class CountriesRates {
//	
//	private String country;
//	private double standard_rate;
//	private double reduced_rate;
//	
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//	public double getStandard_rate() {
//		return standard_rate;
//	}
//	public void setStandard_rate(double standard_rate) {
//		this.standard_rate = standard_rate;
//	}
//	public double getReduced_rate() {
//		return reduced_rate;
//	}
//	public void setReduced_rate(double reduced_rate) {
//		this.reduced_rate = reduced_rate;
//	}
//	
//	@Override
//	public String toString() {
//		return "CountriesRates [country=" + country + ", standard_rate=" + standard_rate + ", reduced_rate="
//				+ reduced_rate + "]";
//	}

