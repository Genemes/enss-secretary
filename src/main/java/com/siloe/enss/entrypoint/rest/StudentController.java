package com.siloe.enss.entrypoint.rest;

import com.siloe.enss.application.usecase.student.create.CreateStudentUseCase;
import com.siloe.enss.application.usecase.student.delete.DeleteStudentUseCase;
import com.siloe.enss.application.usecase.student.update.UpdateStudentUseCase;
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
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final CreateStudentUseCase createSudentUsecase;
    private final DeleteStudentUseCase deleteStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;

    public StudentController(CreateStudentUseCase createStudentUsecase, DeleteStudentUseCase deleteStudentUseCase,
                             UpdateStudentUseCase updateStudentUseCase){
        this.createSudentUsecase = createStudentUsecase;
        this.deleteStudentUseCase = deleteStudentUseCase;
        this.updateStudentUseCase = updateStudentUseCase;
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

    @DeleteMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        logger.info("M=delete, message=Controller, request to delete a Student");

        deleteStudentUseCase.execute(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentVO> update(@RequestBody StudentDTO studentDTO, @PathVariable Long id){
        logger.info("M=update, message=Controller, request to update a Student");

        StudentDTO updateResponse = updateStudentUseCase.execute(studentDTO, id);

        if (Objects.nonNull(updateResponse)){
            logger.info("M=update, message=Controller, student updated successfully, updatedStudent={}", updateResponse);
            return ResponseEntity.status(HttpStatus.OK).body(StudentVO.with(updateResponse.name(), updateResponse.registration(), updateResponse.cpf(),
                    updateResponse.birthCertificate(), updateResponse.serie(), updateResponse.birth(), updateResponse.responsibleId()));
        }

        logger.info("M=update, message=Controller, unable update student");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
