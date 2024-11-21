package com.siloe.enss.infraestructure.presentation;

import com.siloe.enss.domain.dto.LoginRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "account")
public class AccountPresentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @Embedded
    private EmailPresentation email;
    @NotBlank
    private String password;
    @NotNull
    private LocalDate dateRegister;
    @ManyToMany
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RolePresentation> roles = new HashSet<>();

    public boolean removeRole(RolePresentation role) {
        return getRoles().remove(role);
    }

    public boolean addRole(RolePresentation group) {
        return getRoles().add(group);
    }

    public boolean isNew() {
        return getId() == null;
    }

    public boolean isLoginCorrect(LoginRequestDTO loginRequestDTO, PasswordEncoder passwordEncoder){
        return passwordEncoder.matches(loginRequestDTO.password(), this.password);
    }

    public AccountPresentation(){
        this.dateRegister = LocalDate.now();
    }
    public AccountPresentation(Long id, String username, EmailPresentation email, String password, Set<RolePresentation> groups) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateRegister = LocalDate.now();
        this.roles = groups;
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

    public EmailPresentation getEmail() {
        return email;
    }

    public void setEmail(EmailPresentation email) {
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

    public Set<RolePresentation> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolePresentation> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof AccountPresentation other){
            return Objects.equals(this.id, other.getId())
                    && Objects.equals(this.username, other.getUsername())
                    && Objects.equals(this.email, other.getEmail())
                    && Objects.equals(this.password, other.getPassword())
                    && Objects.equals(this.dateRegister, other.getDateRegister())
                    && Objects.equals(this.roles, other.getRoles());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, dateRegister, roles);
    }

    @Override
    public String toString() {
        StringBuilder roleNames = new StringBuilder();
        for (RolePresentation role : roles) {
            roleNames.append("\"").append(role.getName()).append(" - ");
        }

        String formattedRoles = roleNames.length() > 0 ?
                roleNames.substring(0, roleNames.length() - 2) : "[]";

        return """
            Student{
                id=%d,
                username='%s',
                email=%s,
                dateRegister=%s,
                formattedGroups=%s
            }
            """.formatted(id, username, email, dateRegister, formattedRoles);
    }
}
