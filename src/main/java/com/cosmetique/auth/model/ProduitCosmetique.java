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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="produitcosmetique")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PRODUIT",discriminatorType=DiscriminatorType.STRING,length=20)
public class ProduitCosmetique {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	private String libellePorduit;
	@ManyToMany
	@JoinTable(name="EffetCosmetique",joinColumns=@JoinColumn(name="CosmetiqueId"),inverseJoinColumns=@JoinColumn(name="EffetId"))
	private List<Effet> effets;
	@ManyToMany
	@JoinTable(name="Ingredient_Cosmetique",joinColumns=@JoinColumn(name="CosmetiqueId"),inverseJoinColumns=@JoinColumn(name="IngredientId"))
	private List<Ingredient> ingredients;
	
	public List<Effet> getEffets() {
		return effets;
	}
	public void setEffets(List<Effet> effets) {
		this.effets = effets;
	}
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
