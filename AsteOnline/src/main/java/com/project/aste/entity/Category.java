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
@Table(name="Categories")
public class Category {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "idCategory")
		private int idCategory;
		
		@NotEmpty(message = "error.category.name.empty")
		@Column(name = "name")
		private String name;

		public Category() {}
		
		
		public int getIdCategory() {
			return idCategory;
		}

		public void setIdCategory(int idCategory) {
			this.idCategory = idCategory;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
		
		
}
