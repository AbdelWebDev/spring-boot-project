package com.cosmetique.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetique.auth.model.ProduitCosmetique;
public interface ProduitCosmetiqueRepository extends JpaRepository<ProduitCosmetique, Long>{
	
}
