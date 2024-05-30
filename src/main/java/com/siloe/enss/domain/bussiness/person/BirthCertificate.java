package com.siloe.enss.domain.bussiness.person;

import java.util.Objects;

public class BirthCertificate {

    private Long id;
    private Long certificateNumber;
    private String placeOfBirth;
    private String motherName;
    private String fatherName;
    private int bookNumber;
    private int bookPage;

    public BirthCertificate(){}

    private BirthCertificate(Builder builder) {
        id = builder.id;
        certificateNumber = builder.certificateNumber;
        placeOfBirth = builder.placeOfBirth;
        motherName = builder.motherName;
        fatherName = builder.fatherName;
        bookNumber = builder.bookNumber;
        bookPage = builder.bookPage;
    }

    public static class Builder {
        private Long id = null;
        private Long certificateNumber = null;
        private String placeOfBirth = "";
        private String motherName = "";
        private String fatherName = "";
        private int bookNumber = 0;
        private int bookPage = 0;

        public Builder id(Long value){
            id = value;
            return this;
        }

        public Builder certificateNumber(Long value){
            Objects.requireNonNull(value, "Certificate number must not be null");
            certificateNumber = value;
            return this;
        }

        public Builder placeOfBirth(String value){
            Objects.requireNonNull(value, "Place of birth must not be null");
            placeOfBirth = value;
            return this;
        }

        public Builder motherName(String value){
            Objects.requireNonNull(value, "Mother name must not be null");
            motherName = value;
            return this;
        }

        public Builder fatherName(String value){
            Objects.requireNonNull(value, "Father name must not be null");
            fatherName = value;
            return this;
        }

        public Builder bookNumber(int value){
            Objects.requireNonNull(value, "Book number must not be null");
            bookNumber = value;
            return this;
        }

        public Builder bookPage(int value){
            Objects.requireNonNull(value, "Book page must not be null");
            bookPage = value;
            return this;
        }

        public BirthCertificate build(){
            return new BirthCertificate(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthCertificate that = (BirthCertificate) o;
        return bookNumber == that.bookNumber && bookPage == that.bookPage && Objects.equals(id, that.id) && Objects.equals(certificateNumber, that.certificateNumber) && Objects.equals(placeOfBirth, that.placeOfBirth) && Objects.equals(motherName, that.motherName) && Objects.equals(fatherName, that.fatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, certificateNumber, placeOfBirth, motherName, fatherName, bookNumber, bookPage);
    }

    @Override
    public String toString() {
        return "BirthCertificate{" +
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
