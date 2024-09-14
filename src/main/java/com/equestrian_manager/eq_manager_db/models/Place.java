package com.equestrian_manager.eq_manager_db.models;

import jakarta.persistence.*;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String color;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "stable_id")
    private Stable stable;

    public Place(String name) {
        this.name = name;
    }

    public Place() {
    }

    @Override
    public String toString() {
        return "Place[name='%s', color='%s', imgUrl='%s']".formatted(name, color, imgUrl);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }
}
