package com.tew.model;

import java.io.Serializable;

public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String name;
	private String password;
	
	public User() {}
	
	public User(String login, String name) {
		super();
		this.login = login;
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
