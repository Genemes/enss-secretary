package com.siloe.enss.application.usecase.student.delete;

import com.siloe.enss.application.gateway.StudentGateway;
import com.siloe.enss.infraestructure.database.StudentDatabaseGateway;
import com.siloe.enss.infraestructure.mappers.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class DeleteStudentUseCase {

    private static final Logger logger = LoggerFactory.getLogger(DeleteStudentUseCase.class);

    private final StudentMapper studentMapper;

    private final StudentGateway gateway;

    public DeleteStudentUseCase(StudentMapper studentMapper, StudentGateway studentGateway) {
        this.studentMapper = studentMapper;
        this.gateway = studentGateway;
    }

    public boolean delete(Long id){
        Objects.requireNonNull(id, "Id cannot be null!");
        return gateway.delete(id);
    }
}
