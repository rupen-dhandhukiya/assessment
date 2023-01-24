package com.vat.rates.main.model;

public class CountryRates {
	
	private String country;
	private double standard_rate;
	private double reduced_rate;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getStandard_rate() {
		return standard_rate;
	}
	public void setStandard_rate(double standard_rate) {
		this.standard_rate = standard_rate;
	}
	public double getReduced_rate() {
		return reduced_rate;
	}
	public void setReduced_rate(double reduced_rate) {
		this.reduced_rate = reduced_rate;
	}
	@Override
	public String toString() {
		return "CountryRates [country=" + country + ", standard_rate=" + standard_rate + ", reduced_rate="
				+ reduced_rate + "]";
	}
}
