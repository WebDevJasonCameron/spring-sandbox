package com.jasoncodes.springsandbox.Repositories;

import com.jasoncodes.springsandbox.Models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findRecipeByCid(long cid);


}
