package com.cosmetique.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetique.auth.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
}
