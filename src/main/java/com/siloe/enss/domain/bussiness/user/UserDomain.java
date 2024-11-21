package com.siloe.enss.domain.bussiness.user;

import com.siloe.enss.domain.bussiness.person.Email;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDomain {

    private Long id;
    private String username;
    private Email email;
    private String password;
    private LocalDate dateRegister;
    private Set<Group> groups = new HashSet<>();

    public boolean removeGroup(Group group) {
        return getGroups().remove(group);
    }

    public boolean addGroup(Group group) {
        return getGroups().add(group);
    }

    public boolean isNew() {
        return getId() == null;
    }

    public UserDomain(){
        this.dateRegister = LocalDate.now();
    }
    public UserDomain(Long id, String username, Email email, String password, Set<Group> groups) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateRegister = LocalDate.now();
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof UserDomain other){
            return Objects.equals(this.id, other.getId())
                    && Objects.equals(this.username, other.getUsername())
                    && Objects.equals(this.email, other.getEmail())
                    && Objects.equals(this.password, other.getPassword())
                    && Objects.equals(this.dateRegister, other.getDateRegister())
                    && Objects.equals(this.groups, other.getGroups());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, dateRegister, groups);
    }

    @Override
    public String toString() {
        StringBuilder groupNames = new StringBuilder();
        for (Group group : groups) {
            groupNames.append("\"").append(group.getName()).append(" - ");
        }

        String formattedGroups = groupNames.length() > 0 ?
                groupNames.substring(0, groupNames.length() - 2) : "[]";

        return """
            Student{
                id=%d,
                username='%s',
                email=%s,
                dateRegister=%s,
                formattedGroups=%s
            }
            """.formatted(id, username, email, dateRegister, formattedGroups);
    }

}