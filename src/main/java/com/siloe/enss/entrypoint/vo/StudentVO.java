package com.siloe.enss.entrypoint.vo;

import java.time.LocalDate;
import java.util.UUID;

public record StudentVO (String name, String registration, String cpf, String birthCertificate, String serie, LocalDate birth, UUID responsibleId) {
    public static StudentVO with(String name, String registration, String cpf,
                                       String birthCertificate, String serie, LocalDate birth, UUID responsibleId){
        return new StudentVO(name, registration, cpf, birthCertificate, serie, birth, responsibleId);
    }
}