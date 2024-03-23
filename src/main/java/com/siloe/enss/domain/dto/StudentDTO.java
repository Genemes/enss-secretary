package com.siloe.enss.domain.dto;

import com.siloe.enss.domain.bussiness.person.Responsible;

import java.time.LocalDate;
import java.util.UUID;

public record StudentDTO(UUID id, String name, String registration, String cpf, String birthCertificate, String serie, LocalDate birth, UUID responsibleId) {
}
