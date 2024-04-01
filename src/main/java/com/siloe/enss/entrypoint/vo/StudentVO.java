package com.siloe.enss.entrypoint.vo;

import java.time.LocalDate;

public record StudentVO (String name, String registration, String cpf, String birthCertificate, String serie, LocalDate birth, Long responsibleId) {
    public static StudentVO with(String name, String registration, String cpf,
                                       String birthCertificate, String serie, LocalDate birth, Long responsibleId){
        return new StudentVO(name, registration, cpf, birthCertificate, serie, birth, responsibleId);
    }
}