package com.siloe.enss.domain.bussiness.person;

import java.time.LocalDate;
import java.util.*;

public class Responsible {

    private UUID id;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birth;
    private String phone;
    private Email email;
    private Address address;

    private Responsible(Builder builder) {
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
        private Email email = Email.of("");
        private Address address = null;
        private Set<Student> children = null;

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

        public Builder email (String value) {
            email = Email.of(value);
            return this;
        }

        public Builder address (Address value) {
            Objects.requireNonNull(value, "Address must not be null");
            address = value;
            return this;
        }

        public Responsible build() {
            return new Responsible(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Responsible other){
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
                "id=" + id +
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
