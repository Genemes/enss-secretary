package com.siloe.enss.infraestructure.presentation;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "role")
public class RolePresentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ManyToMany
    @JoinTable(name = "role_permission", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<PermissionPresentation> permissions = new HashSet<>();

    public RolePresentation() {}
    public RolePresentation(String name, Set<PermissionPresentation> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public boolean removePermission(PermissionPresentation permission) {
        return getPermissions().remove(permission);
    }

    public boolean addPermission(PermissionPresentation permission) {
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

    public Set<PermissionPresentation> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionPresentation> permissoes) {
        this.permissions = permissoes;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof RolePresentation other){
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
        for (PermissionPresentation permission : permissions) {
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
