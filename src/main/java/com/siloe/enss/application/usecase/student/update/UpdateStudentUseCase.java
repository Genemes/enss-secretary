package com.siloe.enss.application.usecase.student.update;

import com.siloe.enss.application.gateway.StudentGateway;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.infraestructure.mappers.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateStudentUseCase {

    public static final Logger logger = LoggerFactory.getLogger(UpdateStudentUseCase.class);
    private StudentGateway gateway;

    private StudentMapper studentMapper;

    public UpdateStudentUseCase(StudentGateway gateway, StudentMapper studentMapper){
        this.gateway = gateway;
        this.studentMapper = studentMapper;
    }

    public StudentDTO execute(StudentDTO studentDTO, Long id){
        Objects.requireNonNull(studentDTO, "Student cannot be null");
        Objects.requireNonNull(id, "Id cannot be null");

        Student updateResponse = gateway.update(studentMapper.map(studentDTO), id);

        if (Objects.nonNull(updateResponse)) {
            logger.info("M=updateStudent, message=UseCase, student updated successfully, student={}", updateResponse);
            return studentMapper.map(updateResponse);
        }
        return null;
    }
}
