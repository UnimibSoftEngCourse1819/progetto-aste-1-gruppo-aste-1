package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ObjectsAndServices")
public class ObjectService {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idObjSer")
	private int idObjSer;
	
	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@NotEmpty
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Column(name = "startPrice")
	private double startPrice;
	
	@NotNull
	@Column(name = "isObject")
	private boolean idObject;
	
	@NotNull
	@Column(name = "isAvailable")
	private boolean isAvailable;
	
	@NotNull
	@Column(name = "idCategory")
	private int idCategory;
	
	@NotNull
	@Column(name = "idUser")
	private int idUser;
	
	@NotNull
	@Column(name = "idAddress")
	private int idAddress;
	
	
	
	public ObjectService() {
		super();
	}
	
	
	public int getIdObjSer() {
		return idObjSer;
	}
	public void setIdObjSer(int idObjSer) {
		this.idObjSer = idObjSer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}
	public boolean isIdObject() {
		return idObject;
	}
	public void setIdObject(boolean idObject) {
		this.idObject = idObject;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdAddress() {
		return idAddress;
	}
	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}
	
}
