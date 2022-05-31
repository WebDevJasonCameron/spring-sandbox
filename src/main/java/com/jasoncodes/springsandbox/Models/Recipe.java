package com.jasoncodes.springsandbox.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cid", unique = true)
    private long cid;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "summary", length = 2000)
    private String summary;
    @Column(name = "instructions", length = 2000)
    private String instructions;
    @Column(name = "ready_in_minutes")
    private String readyInMinutes;
    @Column(name = "servings")
    private String servings;
    @Column(name = "source_name")
    private String sourceName;
    @Column(name = "source_url")
    private String sourceUrl;
    @Column(name = "vegetarian")
    private boolean vegetarian;
    @Column(name = "vegan")
    private boolean vegan;
    @Column(name = "gluten_free")
    private boolean glutenFree;
    @Column(name = "dairy_free")
    private boolean dairyFree;
    @Column(name = "dish_type")
    private String dishType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @JsonBackReference
    private List<Ingredient> ingredients;




    // CON
    public Recipe() {
    }
    public Recipe(long cid, String title, String imageUrl) {
        this.cid = cid;
        this.title = title;
        this.imageUrl = imageUrl;
    }
    public Recipe(long cid, String title, String imageUrl, String summary, String instructions, String readyInMinutes, String servings, String sourceName, String sourceUrl, boolean vegetarian, boolean vegan, boolean glutenFree, boolean dairyFree, String dishType, List<Ingredient> ingredients) {
        this.cid = cid;
        this.title = title;
        this.imageUrl = imageUrl;
        this.summary = summary;
        this.instructions = instructions;
        this.readyInMinutes = readyInMinutes;
        this.servings = servings;
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.dairyFree = dairyFree;
        this.dishType = dishType;
        this.ingredients = ingredients;
    }




    // GET
    public long getId() {
        return id;
    }
    public long getCid() {
        return cid;
    }
    public String getTitle() {
        return title;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getSummary() {
        return summary;
    }
    public String getInstructions() {
        return instructions;
    }
    public String getReadyInMinutes() {
        return readyInMinutes;
    }
    public String getServings() {
        return servings;
    }
    public String getSourceName() {
        return sourceName;
    }
    public String getSourceUrl() {
        return sourceUrl;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public boolean isVegan() {
        return vegan;
    }
    public boolean isGlutenFree() {
        return glutenFree;
    }
    public boolean isDairyFree() {
        return dairyFree;
    }
    public String getDishType() {
        return dishType;
    }



    // SET
    public void setCid(long cid) {
        this.cid = cid;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public void setReadyInMinutes(String readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }
    public void setServings(String servings) {
        this.servings = servings;
    }
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }
    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }
    public void setDishType(String dishType) {
        this.dishType = dishType;
    }


// CHECK
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", instructions='" + instructions + '\'' +
                ", readyInMinutes='" + readyInMinutes + '\'' +
                ", servings='" + servings + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", glutenFree=" + glutenFree +
                ", dairyFree=" + dairyFree +
                ", dishType='" + dishType + '\'' +
                '}';
    }


}  //<--END
