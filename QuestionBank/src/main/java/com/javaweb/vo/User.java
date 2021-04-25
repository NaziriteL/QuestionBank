package com.javaweb.vo;

import java.io.Serializable;;
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Boolean isAdmin;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
}
