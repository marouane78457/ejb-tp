package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity

public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String nom ;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToMany
	@JoinTable(name = "user_role",
				joinColumns = @JoinColumn (name = "Fid"),
				inverseJoinColumns = @JoinColumn(name = "Uid"))
	private List<User> us = new ArrayList<>();

	public Role(int id, String nom, List<User> us) {
		super();
		this.id = id;
		this.nom = nom;
		this.us = us;
	}
	public List<User> getUs() {
		return us;
	}
	public void setUs(List<User> us) {
		this.us = us;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	} 
	@Override
	public String toString() {
		return "Role [us=" + us + ", id=" + id + ", nom=" + nom + "]";
	}

}
