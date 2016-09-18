package org.xstio.ImageManager.metier;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	private int id;
	private String libelle;
	private Set<Image> images;
	
	@Id
	@GeneratedValue
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	@ManyToMany(mappedBy="tags")
	public Set<Image> getImages() {	return images;}
	public void setImages(Set<Image> images) {this.images = images; }
	
	public Tag() { this(0,""); }
	public Tag(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
}
