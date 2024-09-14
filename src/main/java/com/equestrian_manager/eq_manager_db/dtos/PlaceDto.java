package com.equestrian_manager.eq_manager_db.dtos;

public class PlaceDto {
    private Long id;
    private String name;
    private String color;
    private String imgUrl;
    private Long stableId;

    public PlaceDto(String name) {
        this.name = name;
    }

    public PlaceDto() {
    }

    @Override
    public String toString() {
        return "Place [name='%s']".formatted(name);
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

    public Long getStableId() {
        return stableId;
    }

    public void setStableId(Long stableId) {
        this.stableId = stableId;
    }
}
