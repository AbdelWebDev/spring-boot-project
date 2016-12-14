package com.cosmetique.auth.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PRODUIT",discriminatorType=DiscriminatorType.STRING,length=20)

public class Ingredient {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String libelleIngredient;
	@ManyToMany(mappedBy="ingredients")
	private List<ProduitCosmetique> produits;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleIngredient() {
		return libelleIngredient;
	}
	public void setLibelleIngredient(String libelleIngredient) {
		this.libelleIngredient = libelleIngredient;
	}
	public List<ProduitCosmetique> getProduits() {
		return produits;
	}
	public void setProduits(List<ProduitCosmetique> produits) {
		this.produits = produits;
	}
	public Ingredient() {
		super();
	}
	public Ingredient(String libelleIngredient) {
		super();
		this.libelleIngredient = libelleIngredient;
	}
	
	
	
}
