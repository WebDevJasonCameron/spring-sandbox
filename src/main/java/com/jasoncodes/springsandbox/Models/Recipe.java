package com.jasoncodes.springsandbox.Models;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {

    // AT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long apiId;
    @Column
    private String title;
    @Column
    private String image;


    // CON
    public Recipe() {

    }
    public Recipe(long apiId, String title, String image) {
        this.apiId = apiId;
        this.title = title;
        this.image = image;
    }


    // GET
    public long getId() {
        return id;
    }
    public long getApiId() {
        return apiId;
    }
    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }


    // SET
    public void setId(long id) {
        this.id = id;
    }
    public void setApiId(long apiId) {
        this.apiId = apiId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }


    // CHECK
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }


}  //<--END
