package figueiredoisaac.com.sprintmanager.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
