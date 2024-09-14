package com.equestrian_manager.eq_manager_db.dtos;

import java.util.List;

public class StableDto {
    private Long id;
    private String name;
    private Long ownerId;
    private List<Long> clientsIds;
    private List<Long> placesIds;

    public StableDto(String name) {
        this.name = name;
    }

    public StableDto() {
    }

    @Override
    public String toString() {
        return "Stable [name='%s']".formatted(name);
    }

    public Long getId() {
        return this.id;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<Long> getPlacesIds() {
        return placesIds;
    }

    public void setPlacesIds(List<Long> placesIds) {
        this.placesIds = placesIds;
    }

    public List<Long> getClientsIds() {
        return clientsIds;
    }

    public void setClientsIds(List<Long> clientsIds) {
        this.clientsIds = clientsIds;
    }
}
