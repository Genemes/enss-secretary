package com.siloe.enss.application.usecase.student.create;

import com.siloe.enss.application.gateway.StudentGateway;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.infraestructure.mappers.StudentMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreateStudentUseCase {

    private static final Logger logger = LoggerFactory.getLogger(CreateStudentUseCase.class);

    private final StudentMapper mapper;

    private final StudentGateway gateway;


    public CreateStudentUseCase(StudentGateway gateway, StudentMapper mapper) {
        this.gateway = gateway;
        this.mapper = mapper;
    }

    public StudentDTO execute(StudentDTO studentDTO) {
        Objects.requireNonNull(studentDTO, "StudentDTO cannot be null!");

        Student savedStudent = gateway.create(mapper.map(studentDTO));
        logger.info("M=createStudent, message=UseCase, student return successfully, student={}", savedStudent);

        return mapper.map(savedStudent);
    }

}
