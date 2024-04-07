package com.siloe.enss.entrypoint.rest;

import com.siloe.enss.application.usecase.student.create.CreateStudentUsecase;
import com.siloe.enss.application.usecase.student.delete.DeleteStudentUseCase;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.entrypoint.vo.StudentVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final CreateStudentUsecase createSudentUsecase;
    private final DeleteStudentUseCase deleteStudentUseCase;

    public StudentController(CreateStudentUsecase createStudentUsecase, DeleteStudentUseCase deleteStudentUseCase){
        this.createSudentUsecase = createStudentUsecase;
        this.deleteStudentUseCase = deleteStudentUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentVO> create(@RequestBody StudentDTO studentDTO) {
        logger.info("M=create, message=Controller, request to create a successfully received Student");

        StudentDTO createdStudent = createSudentUsecase.execute(studentDTO);

        URI uri = UriComponentsBuilder.fromUriString("/api/v1/student/{id}").build(createdStudent.id());

        logger.info("M=create, message=Controller, student created successfully, createdStudent={}", createdStudent);

        return ResponseEntity.created(uri).body(StudentVO.with(createdStudent.name(), createdStudent.registration(), createdStudent.cpf(),
                createdStudent.birthCertificate(), createdStudent.serie(), createdStudent.birth(), createdStudent.responsibleId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        logger.info("M=delete, message=Controller, request to delete a Student");

        deleteStudentUseCase.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
