package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_compte;
	
	@Column
	private String login;
	
	@Column
	private String passwd;
	
	@Column
	private String type;  	//enum type{admin_DRH,chef_DRH};

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(int id_compte, String login, String passwd, String type) {
		super();
		this.id_compte = id_compte;
		this.login = login;
		this.passwd = passwd;
		this.type = type;
	}

	public int getId_compte() {
		return id_compte;
	}

	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	
	
}
