package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Addresses")
public class Address {

	@Id	
	@Column(name="idAddress")
	private int idAddress;
	
	@Column(name="street")
	@NotEmpty(message = "error.street.empty")
	private String street;
	
	@Column(name="city")
	@NotEmpty(message = "error.city.empty")
	private String city;
	
	@Column(name="province")
	@NotEmpty(message = "error.province.empty")
	private String province;
	
	@Column(name="nation")
	@NotEmpty(message = "error.nation.empty")
	private String nation;
	
	@Column(name="houseNumber")
	@NotEmpty(message = "error.houseNumber.empty")
	private String houseNumber;
	
	@Column(name="postalCode")
	@NotNull
	private int postalCode;
	
	
	
	public Address() {
		super();
	}


	public Address( int idAddress, String street, String province, String nation, String houseNumber,
			int postalCode) {
		super();
		this.idAddress = idAddress;
		this.street = street;
		this.province = province;
		this.nation = nation;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
	}



	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getIdAddress() {
		return idAddress;
	}


	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	public String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public int getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	
	
	
}
