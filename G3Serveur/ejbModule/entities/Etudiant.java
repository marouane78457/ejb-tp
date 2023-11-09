package entities;


import java.io.Serializable;
import java.lang.String;

import jakarta.persistence.Entity;


/**
 * Entity implementation class for Entity: Etudiant
 *
 */

@Entity
public class Etudiant extends User implements Serializable {
	 private String firstname;
	 private String Lastname;
	 private String telephone;

	public Etudiant(String firstname, String lastname, String telephone) {
		super();
		this.firstname = firstname;
		Lastname = lastname;
		this.telephone = telephone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	


   
}
