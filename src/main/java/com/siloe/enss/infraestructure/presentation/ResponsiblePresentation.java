package com.siloe.enss.infraestructure.presentation;

import com.siloe.enss.domain.bussiness.person.Email;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity(name = "responsible")
public class ResponsiblePresentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birth;
    private String phone;
    @Embedded
    private EmailPresentation email;
    @OneToOne
    private AddressPresentation address;

    public ResponsiblePresentation(){}
    private ResponsiblePresentation(Builder builder) {
        name = builder.name;
        cpf = builder.cpf;
        rg = builder.rg;
        birth = builder.birth;
        phone = builder.phone;
        email = builder.email;
        address = builder.address;
    }
    public static class Builder {
        private String name = "";
        private String cpf = "";
        private String rg = "";
        private LocalDate birth = LocalDate.now();
        private String phone = "";
        private EmailPresentation email = EmailPresentation.of("");
        private AddressPresentation address = null;
        private Set<StudentPresentation> children = null;

        public Builder name (String value) {
            Objects.requireNonNull(value, "Name must not be null");
            name = value;
            return this;
        }

        public Builder cpf (String value) {
            Objects.requireNonNull(value, "CPF must not be null");
            cpf = value;
            return this;
        }

        public Builder rg (String value) {
            Objects.requireNonNull(value, "RG must not be null");
            rg = value;
            return this;
        }

        public Builder birth (LocalDate value) {
            Objects.requireNonNull(value, "Birth must not be null");
            if (value.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Birth date must be a valid date");
            }
            birth = value;
            return this;
        }

        public Builder phone (String value) {
            Objects.requireNonNull(value, "Phone must not be null");
            phone = value;
            return this;
        }

        public Builder email (EmailPresentation value) {
            email = EmailPresentation.of(value.toString());
            return this;
        }

        public Builder address (AddressPresentation value) {
            Objects.requireNonNull(value, "Address must not be null");
            address = value;
            return this;
        }

        public ResponsiblePresentation build() {
            return new ResponsiblePresentation(this);
        }
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmailPresentation getEmail() {
        return email;
    }

    public void setEmail(EmailPresentation email) {
        this.email = email;
    }

    public AddressPresentation getAddress() {
        return address;
    }

    public void setAddress(AddressPresentation address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ResponsiblePresentation other){
            return Objects.equals(this.id, other.id)
                    && Objects.equals(this.name, other.name)
                    && Objects.equals(this.cpf, other.cpf)
                    && Objects.equals(this.rg, other.rg)
                    && Objects.equals(this.birth, other.birth)
                    && Objects.equals(this.phone, other.phone)
                    && Objects.equals(this.email, other.email)
                    && Objects.equals(this.address, other.address);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, rg, birth, phone, email, address);
    }

    @Override
    public String toString() {
        return "Responsible{" +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", email=" + email +
                ", address=" + address +
                '}';
    }
}
