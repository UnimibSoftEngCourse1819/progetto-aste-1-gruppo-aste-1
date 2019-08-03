package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Attributes")
public class Attribute {
	
	@Id
	@Column(name = "idAttribute")
	private int idAttribute;
	//
	@Column(name = "name")
	private String name;
	
	public int getIdAttribute() {
		return idAttribute;
	}
	public void setIdAttribute(int idAttribute) {
		this.idAttribute = idAttribute;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
