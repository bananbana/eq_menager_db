package com.equestrian_manager.eq_manager_db.dtos;

import java.util.List;

public class UserDto {
    private Long id;
    private String fullName;
    private String email;
    private List<Long> stableIds;
    private List<Long> roleIds;

    public UserDto(String fullName) {
        this.fullName = fullName;
    }

    public UserDto() {

    }

    @Override
    public String toString() {
        return "User [fullName='%s']".formatted(fullName);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getStableIds() {
        return stableIds;
    }

    public void setStableIds(List<Long> stableIds) {
        this.stableIds = stableIds;
    }

    public List<Long> getRoles() {
        return roleIds;
    }

    public void setRoles(List<Long> rolesIds) {
        this.roleIds = rolesIds;
    }
}
