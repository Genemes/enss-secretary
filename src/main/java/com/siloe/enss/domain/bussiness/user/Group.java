package com.siloe.enss.domain.bussiness.user;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {

    private Long id;

    private String name;

    private Set<Permission> permissions = new HashSet<>();

    public  Group() {}
    public Group(Long id, String name, Set<Permission> permissions) {
        this.id = id;
        this.name = name;
        this.permissions = permissions;
    }

    public boolean removePermission(Permission permission) {
        return getPermissions().remove(permission);
    }

    public boolean addPermission(Permission permission) {
        return getPermissions().add(permission);
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissoes) {
        this.permissions = permissoes;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Group other){
            return Objects.equals(this.id, other.getId())
                    && Objects.equals(this.name, other.getName())
                    && Objects.equals(this.permissions, other.getPermissions());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, permissions);
    }

    @Override
    public String toString() {
        StringBuilder permissionNames = new StringBuilder();
        for (Permission permission : permissions) {
            permissionNames.append("\"").append(permission.getName()).append(" - ");
        }

        String formattedPermissions = permissionNames.length() > 0 ?
                permissionNames.substring(0, permissionNames.length() - 2) : "[]";

        return """
            Group{
                id=%d,
                name='%s',
                permissions=%s
            }
            """.formatted(id, name, formattedPermissions);
    }


}
