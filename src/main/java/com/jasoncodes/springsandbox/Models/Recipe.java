package com.jasoncodes.springsandbox.Models;


import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {

    // ATT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "cid")
    private long cid;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "image_url")
    private String imageUrl;

    // CON
    public Recipe() {
    }
    public Recipe(long cid, String title, String imageUrl) {
        this.cid = cid;
        this.title = title;
        this.imageUrl = imageUrl;
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


    // CHECK
    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


}  //<--END
