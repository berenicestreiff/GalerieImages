package org.xstio.ImageManager.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Galerie {
	private int id;
	private String nom;
	private Date dateCreation;
	private Set<Image> images;
	
	@Id
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	@Temporal(TemporalType.DATE)
	public Date getDateCreation() {return dateCreation;}
	public void setDateCreation(Date dateCreation) {this.dateCreation = dateCreation;}
	@OneToMany(mappedBy="galerie")
	public Set<Image> getImages() {
		if (images == null) 
			images = new HashSet<>();
		return images;
	}
	public void setImages(Set<Image> images) {this.images = images;}
	
	public Galerie() { this(0,"",null); }
	public Galerie(int id, String nom, Date dateCreation) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
	}
}
