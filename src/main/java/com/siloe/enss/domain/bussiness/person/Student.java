package com.siloe.enss.domain.bussiness.person;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private Long id;
    private String name;
    private String registration;
    private String cpf;
    private BirthCertificate birthCertificate;
    private String serie;
    private LocalDate birth;
    private Long responsibleId;

    private Student(Builder builder) {
        id = builder.id;
        name = builder.name;
        registration = builder.registration;
        cpf = builder.cpf;
        birthCertificate = builder.birthCertificate;
        serie = builder.serie;
        birth = builder.birth;
        responsibleId = builder.responsibleId;
    }

    public static class Builder {
        private Long id = null;
        private String name = "";
        private String registration = "";
        private String cpf = "";
        private BirthCertificate birthCertificate = null;
        private String serie = "";
        private LocalDate birth = LocalDate.now();
        private Long responsibleId = null;

        public Builder id(Long value) {
            id = value;
            return this;
        }
        public Builder name(String value) {
            Objects.requireNonNull(value, "Name must not be null");
            name = value;
            return this;
        }
        public Builder registration(String value) {
            Objects.requireNonNull(value, "Registration must not be null");
            registration = value;
            return this;
        }
        public Builder cpf(String value) {
            Objects.requireNonNull(value, "CPF must not be null");
            cpf = value;
            return this;
        }

        public Builder birthCertificate(BirthCertificate birthCertificate) {
            Objects.requireNonNull(birthCertificate, "Birth certificate must not be null");
            this.birthCertificate = birthCertificate;
            return this;
        }

        public Builder serie(String value) {
            Objects.requireNonNull(value, "Serie must not be null");
            serie = value;
            return this;
        }

        public Builder birth(LocalDate value) {
            Objects.requireNonNull(value, "Birth must not be null");
            if (value.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Birth date must be a valid date");
            }
            birth = value;
            return this;
        }

        public Builder responsible(Long value) {
            Objects.requireNonNull(value, "Responsible must not be null");
            responsibleId = value;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }


    // Getters and Setters
    public Long getResponsibleId() {
        return this.responsibleId;
    }

    public void setResponsibleId(Long responsible) {
        this.responsibleId = responsible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BirthCertificate getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(BirthCertificate birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student other){
            return Objects.equals(this.id, other.id)
                    && Objects.equals(this.name, other.name)
                    && Objects.equals(this.registration, other.registration)
                    && Objects.equals(this.cpf, other.cpf)
                    && Objects.equals(this.birthCertificate, other.birthCertificate)
                    && Objects.equals(this.serie, other.serie)
                    && Objects.equals(this.birth, other.birth)
                    && Objects.equals(this.responsibleId, other.responsibleId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, registration, cpf, birthCertificate, serie, birth, responsibleId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthCertificate='" + birthCertificate + '\'' +
                ", serie='" + serie + '\'' +
                ", birth=" + birth +
                '}';
    }
}
