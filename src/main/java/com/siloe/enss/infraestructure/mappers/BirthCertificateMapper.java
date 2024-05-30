package com.siloe.enss.infraestructure.mappers;

import com.siloe.enss.domain.bussiness.person.BirthCertificate;
import com.siloe.enss.domain.dto.BirthCertificateDTO;
import com.siloe.enss.infraestructure.presentation.BirthCertificatePresentation;

public class BirthCertificateMapper {

    public BirthCertificate presentationToMap(BirthCertificatePresentation presentation){
        return new BirthCertificate.Builder()
                .id(presentation.getId())
                .certificateNumber(presentation.getCertificateNumber())
                .placeOfBirth(presentation.getPlaceOfBirth())
                .motherName(presentation.getMotherName())
                .fatherName(presentation.getFatherName())
                .bookNumber(presentation.getBookNumber())
                .bookPage(presentation.getBookPage())
                .build();
    }

    public BirthCertificate dtoToMap(BirthCertificateDTO birthCertificateDTO){
        return new BirthCertificate.Builder()
                .certificateNumber(birthCertificateDTO.certificateNumber())
                .placeOfBirth(birthCertificateDTO.placeOfBirth())
                .motherName(birthCertificateDTO.motherName())
                .fatherName(birthCertificateDTO.fatherName())
                .bookNumber(birthCertificateDTO.bookNumber())
                .bookPage(birthCertificateDTO.bookPage())
                .build();
    }

    public BirthCertificateDTO mapToDto(BirthCertificate birthCertificate){
        return new BirthCertificateDTO(birthCertificate.getCertificateNumber(),
                birthCertificate.getPlaceOfBirth(), birthCertificate.getMotherName(),
                birthCertificate.getFatherName(), birthCertificate.getBookNumber(),
                birthCertificate.getBookPage());
    }

    public BirthCertificatePresentation mapToPresentation(BirthCertificate birthCertificate){
        return new BirthCertificatePresentation.Builder()
                .id(birthCertificate.getId())
                .certificateNumber(birthCertificate.getCertificateNumber())
                .placeOfBirth(birthCertificate.getPlaceOfBirth())
                .motherName(birthCertificate.getMotherName())
                .fatherName(birthCertificate.getFatherName())
                .bookNumber(birthCertificate.getBookNumber())
                .bookPage(birthCertificate.getBookPage())
                .build();
    }
}
