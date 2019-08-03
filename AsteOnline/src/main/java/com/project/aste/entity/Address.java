package com.project.aste.entity;

public class Address {

	private int id;
	private int idAddress;
	private String street;
	private String province;
	private String nation;
	private String houseNumber;
	private int postalCode;
	
	
	public Address(int id, int idAddress, String street, String province, String nation, String houseNumber,
			int postalCode) {
		super();
		this.id = id;
		this.idAddress = idAddress;
		this.street = street;
		this.province = province;
		this.nation = nation;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
