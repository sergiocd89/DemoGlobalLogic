package com.globallogic.model;

import java.io.Serializable;

public class UsuarioPhoneRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4053917389663176001L;

	/**
	 * N�mero telefono celular
	 */
	private String number;

	/**
	 * c�digo de la ciudad
	 */
	private String citycode;

	/**
	 * c�digo del pais
	 */
	private String countrycode;
		
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public String toString() {
		return "Number[" + getNumber() + "] Citycode[" + getCitycode() + "] Countrycode[" + getCountrycode() + "]";
	} 
}
