package com.siloe.enss.infraestructure.presentation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "student")
public class StudentPresentation {

    @Id
    private UUID id;
    private String name;
    private String registration;
    private String cpf;
    private String birthCertificate;
    private String serie;
    private LocalDate birth;
    private UUID responsibleId;

    public StudentPresentation(){}
    private StudentPresentation(Builder builder) {
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
        private UUID id = UUID.randomUUID();
        private String name = "";
        private String registration = "";
        private String cpf = "";
        private String birthCertificate = "";
        private String serie = "";
        private LocalDate birth = LocalDate.now();
        private UUID responsibleId = null;

        public StudentPresentation.Builder id(UUID value) {
            Objects.requireNonNull(value, "Id must not be null");
            id = value;
            return this;
        }
        public StudentPresentation.Builder name(String value) {
            Objects.requireNonNull(value, "Name must not be null");
            name = value;
            return this;
        }
        public StudentPresentation.Builder registration(String value) {
            Objects.requireNonNull(value, "Registration must not be null");
            registration = value;
            return this;
        }
        public StudentPresentation.Builder cpf(String value) {
            Objects.requireNonNull(value, "CPF must not be null");
            cpf = value;
            return this;
        }

        public StudentPresentation.Builder birthCertificate(String value) {
            Objects.requireNonNull(value, "Birth certificate must not be null");
            birthCertificate = value;
            return this;
        }

        public StudentPresentation.Builder serie(String value) {
            Objects.requireNonNull(value, "Serie must not be null");
            serie = value;
            return this;
        }

        public StudentPresentation.Builder birth(LocalDate value) {
            Objects.requireNonNull(value, "Birth must not be null");
            if (value.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Birth date must be a valid date");
            }
            birth = value;
            return this;
        }

        public StudentPresentation.Builder responsibleId(UUID value) {
            Objects.requireNonNull(value, "Responsible must not be null");
            responsibleId = value;
            return this;
        }

        public StudentPresentation build() {
            return new StudentPresentation(this);
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getRegistration() {
        return registration;
    }

    public void setRegistration(@NonNull String registration) {
        this.registration = registration;
    }

    @NonNull
    public String getCpf() {
        return cpf;
    }

    public void setCpf(@NonNull String cpf) {
        this.cpf = cpf;
    }

    @NonNull
    public String getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(@NonNull String birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    @NonNull
    public String getSerie() {
        return serie;
    }

    public void setSerie(@NonNull String serie) {
        this.serie = serie;
    }

    @NonNull
    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(@NonNull LocalDate birth) {
        this.birth = birth;
    }

    @NonNull
    public UUID getResponsible() {
        return responsibleId;
    }

    public void setResponsible(@NonNull UUID responsible) {
        this.responsibleId = responsible;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof StudentPresentation other){
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
        return "StudentPresentation{" +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthCertificate='" + birthCertificate + '\'' +
                ", serie='" + serie + '\'' +
                ", birth=" + birth +
                '}';
    }
}
