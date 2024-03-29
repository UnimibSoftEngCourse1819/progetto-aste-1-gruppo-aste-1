package com.project.aste.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Role")
public class Role {

		public Role() {}
	@Id
	@Column(name="idRole")
	private int idRole;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	public Role(int idRole, String name) {
		super();
		this.idRole = idRole;
		this.name = name;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
