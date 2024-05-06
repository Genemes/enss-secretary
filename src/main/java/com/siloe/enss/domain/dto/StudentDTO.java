package com.siloe.enss.domain.dto;

import com.siloe.enss.domain.bussiness.person.Responsible;

import java.time.LocalDate;

public record StudentDTO(String name, String registration, String cpf, String birthCertificate, String serie, LocalDate birth, Long responsibleId) {
}
