package com.jasoncodes.springsandbox.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "ingredient_name")
    private String ingredientName;
    @Column(name = "ingredient_original")
    private String ingredientOriginal;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;




    // CON
    public Ingredient() {
    }
    public Ingredient(String ingredientName, String ingredientOriginal) {
        this.ingredientName = ingredientName;
        this.ingredientOriginal = ingredientOriginal;
    }
    public Ingredient(String ingredientName, String ingredientOriginal, Recipe recipe) {
        this.ingredientName = ingredientName;
        this.ingredientOriginal = ingredientOriginal;
        this.recipe = recipe;
    }

    // GET
    public long getId() {
        return id;
    }
    public String getIngredientName() {
        return ingredientName;
    }
    public String getIngredientOriginal() {
        return ingredientOriginal;
    }
    public Recipe getRecipe() {
        return recipe;
    }

    // SET
    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
    public void setIngredientOriginal(String ingredientOriginal) {
        this.ingredientOriginal = ingredientOriginal;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    // CHECK
    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", ingredientOriginal='" + ingredientOriginal + '\'' +
                '}';
    }
}  //<--END
