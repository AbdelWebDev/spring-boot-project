package com.cosmetique.auth.model;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Effet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String libelleEffet;
	@ManyToMany(mappedBy="effets")
	private Set<ProduitCosmetique> produits;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getLibelleEffet() {
		return libelleEffet;
	}
	public void setLibelleEffet(String libelleEffet) {
		this.libelleEffet = libelleEffet;
	}
	public Set<ProduitCosmetique> getProduits() {
		return produits;
	}
	public void setProduits(Set<ProduitCosmetique> produits) {
		this.produits = produits;
	}
	public Effet(String libelleEffet) {
		super();
		this.libelleEffet = libelleEffet;
	}
	public Effet() {
		super();
	}
	
	

}
