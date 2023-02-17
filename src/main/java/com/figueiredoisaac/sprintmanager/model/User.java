package com.figueiredoisaac.sprintmanager.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="users")
public class User {

		@Id 
		@Basic(optional = false)
		@Column(unique=true, nullable = false)
		private String username;
		
		@Column(nullable = false)
		private String password;
		private Boolean enabled;
		
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
