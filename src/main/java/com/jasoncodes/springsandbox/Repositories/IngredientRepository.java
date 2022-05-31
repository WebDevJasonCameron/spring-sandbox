package com.jasoncodes.springsandbox.Repositories;

import com.jasoncodes.springsandbox.Models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
