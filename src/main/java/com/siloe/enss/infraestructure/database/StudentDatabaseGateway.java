package com.siloe.enss.infraestructure.database;

import com.siloe.enss.application.gateway.StudentGateway;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.infraestructure.mappers.StudentMapper;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import com.siloe.enss.infraestructure.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentDatabaseGateway implements StudentGateway {

    private static final Logger logger = LoggerFactory.getLogger(StudentDatabaseGateway.class);
    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentDatabaseGateway (StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public Student create(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("student cannot be null.");
        }

        StudentPresentation presentation = mapper.mapToPresentation(student);
        logger.info("M=createStudent, message=StudentDatabaseGateway, student return successfully, student={}", presentation);

        repository.save(presentation);

        return student;
    }
}
