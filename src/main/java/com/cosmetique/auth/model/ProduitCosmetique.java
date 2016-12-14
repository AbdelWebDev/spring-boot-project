package com.cosmetique.auth.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProduitCosmetique {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String libellePorduit;
	@ManyToMany
	@JoinTable(name="Cosmetique_Ingredient",joinColumns=@JoinColumn(name="CosmetiqueId"),inverseJoinColumns=@JoinColumn(name="IngredientId"))
	private List<Ingredient> ingredients;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibellePorduit() {
		return libellePorduit;
	}
	public void setLibellePorduit(String libellePorduit) {
		this.libellePorduit = libellePorduit;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public ProduitCosmetique() {
		super();
	}
	public ProduitCosmetique(String libellePorduit) {
		super();
		this.libellePorduit = libellePorduit;
	}
	

}
