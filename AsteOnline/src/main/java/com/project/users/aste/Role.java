package com.project.users.aste;

public class Role {

	private int idRole;
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
