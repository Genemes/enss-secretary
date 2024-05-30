package com.siloe.enss.infraestructure.presentation;

import com.siloe.enss.domain.bussiness.person.Student;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "birth_certificate")
public class BirthCertificatePresentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long certificateNumber;
    private String placeOfBirth;
    private String motherName;
    private String fatherName;
    private int bookNumber;
    private int bookPage;

    @OneToOne(mappedBy = "birthCertificate")
    private StudentPresentation student;

    public BirthCertificatePresentation(){}
    public BirthCertificatePresentation(Builder builder) {
        id = builder.id;
        certificateNumber = builder.certificateNumber;
        placeOfBirth = builder.placeOfBirth;
        motherName = builder.motherName;
        fatherName = builder.fatherName;
        bookNumber = builder.bookNumber;
        bookPage = builder.bookPage;
    }

    public static class Builder {

        private Long id;
        private Long certificateNumber;
        private String placeOfBirth;
        private String motherName;
        private String fatherName;
        private int bookNumber;
        private int bookPage;

        public Builder id(Long value){
            id = value;
            return this;
        }

        public Builder certificateNumber(Long value){
            certificateNumber = value;
            return this;
        }

        public Builder placeOfBirth(String value){
            placeOfBirth = value;
            return this;
        }

        public Builder motherName(String value){
            motherName = value;
            return this;
        }

        public Builder fatherName(String value){
            fatherName = value;
            return this;
        }

        public Builder bookNumber(int value){
            bookNumber = value;
            return this;
        }

        public Builder bookPage(int value){
            bookPage = value;
            return this;
        }

        public BirthCertificatePresentation build(){
            return new BirthCertificatePresentation(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(Long certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public StudentPresentation getStudent() {
        return student;
    }

    public void setStudent(StudentPresentation student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthCertificatePresentation that = (BirthCertificatePresentation) o;
        return bookNumber == that.bookNumber && bookPage == that.bookPage && Objects.equals(id, that.id) && Objects.equals(certificateNumber, that.certificateNumber) && Objects.equals(placeOfBirth, that.placeOfBirth) && Objects.equals(motherName, that.motherName) && Objects.equals(fatherName, that.fatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, certificateNumber, placeOfBirth, motherName, fatherName, bookNumber, bookPage);
    }

    @Override
    public String toString() {
        return "BirthCertificatePresentation{" +
                "id=" + id +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", motherName='" + motherName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", bookNumber=" + bookNumber +
                ", bookPage=" + bookPage +
                '}';
    }
}
