package com.siloe.enss.entrypoint.vo;

import com.siloe.enss.domain.bussiness.person.BirthCertificate;

import java.time.LocalDate;

public record StudentVO (Long id, String name, String registration, String cpf, BirthCertificate birthCertificate, String serie, LocalDate birth, Long responsibleId) {
    public static StudentVO with(Long id, String name, String registration, String cpf,
                                 BirthCertificate birthCertificate, String serie, LocalDate birth, Long responsibleId){
        return new StudentVO(id, name, registration, cpf, birthCertificate, serie, birth, responsibleId);
    }
}