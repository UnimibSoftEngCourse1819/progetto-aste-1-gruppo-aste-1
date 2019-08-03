package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AttributesCategoriesMap")
public class AttributeCategoryMap {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "idCategory")
	private int idCategory;
	@Column(name = "idAttribute")
	private int idAttribute;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public int getIdAttribute() {
		return idAttribute;
	}
	public void setIdAttribute(int idAttribute) {
		this.idAttribute = idAttribute;
	}
	
	
	
	
	
	
	
	
}
