package com.siloe.enss.domain.bussiness.user;

import java.util.Objects;

public class Permission {

    private Long id;
    private String name;
    private String description;

    public Permission(){}
    public Permission(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Permission other){
            return Objects.equals(this.id, other.id)
                    && Objects.equals(this.name, other.name)
                    && Objects.equals(this.description, other.description);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return """
            Permission{
                id=%d,
                name='%s',
                description=%s,
            """.formatted(id, name, description);
    }
}
