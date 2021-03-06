package com.altersis.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Serveur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@Column (unique =true)
	@NotNull
	private String ipAddress;
	private String memory;
	private String type;
	private String imgURL;
	private Status status;
	
	public Serveur(String name, String ipAddress, String memory, String type, String imgURL, Status status) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
		this.memory = memory;
		this.type = type;
		this.imgURL = imgURL;
		this.status = status;
	}
	public Serveur(Long id, String name, String ipAddress, String memory, String type, String imgURL, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.ipAddress = ipAddress;
		this.memory = memory;
		this.type = type;
		this.imgURL = imgURL;
		this.status = status;
	}
	public Serveur() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

}
