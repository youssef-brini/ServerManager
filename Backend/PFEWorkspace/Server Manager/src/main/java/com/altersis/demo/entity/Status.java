package com.altersis.demo.entity;

public enum Status {
	Server_UP("Server_UP"),
	Server_Down("Server_Down");
	private final String status; 
	Status(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	

}
