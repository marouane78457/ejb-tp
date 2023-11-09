package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Uid;
	private String nom;
	private String prenom;
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "user_role", 
         joinColumns=@JoinColumn(name = "Uid"), 
         inverseJoinColumns = @JoinColumn(name = "id") 
    )
    
    private List <Role> roles = new ArrayList<>();
    




	public User() {
		super();
	}

	
	public User(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}


	public int getId() {
		return Uid;
	}

	public void setId(int id) {
		this.Uid = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [id=" + Uid + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
	

}
