package com.project.aste.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="AttributesCategoriesMap")
public class AttributeCategoryMap {
	
	private int id;
	private int idCategory;
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
