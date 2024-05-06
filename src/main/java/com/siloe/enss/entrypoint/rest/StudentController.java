package com.siloe.enss.entrypoint.rest;

import com.siloe.enss.application.usecase.student.create.CreateStudentUseCase;
import com.siloe.enss.application.usecase.student.delete.DeleteStudentUseCase;
import com.siloe.enss.application.usecase.student.update.UpdateStudentUseCase;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.entrypoint.vo.StudentVO;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
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

        Student createdStudent = createSudentUsecase.execute(studentDTO);

        logger.info("M=create, message=Controller, student created successfully, createdStudent={}", createdStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(StudentVO.with(createdStudent.getId(), createdStudent.getName(), createdStudent.getRegistration(), createdStudent.getCpf(),
                createdStudent.getBirthCertificate(), createdStudent.getSerie(), createdStudent.getBirth(), createdStudent.getResponsibleId()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        logger.info("M=delete, message=Controller, request to delete a Student");

        boolean deletionResponse = deleteStudentUseCase.execute(id);

        if (deletionResponse) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentVO> update(@RequestBody StudentDTO studentDTO, @PathVariable Long id){
        logger.info("M=update, message=Controller, request to update a Student");

        Student updateResponse = updateStudentUseCase.execute(studentDTO, id);

        if (Objects.nonNull(updateResponse)){
            logger.info("M=update, message=Controller, student updated successfully, updatedStudent={}", updateResponse);
            return ResponseEntity.status(HttpStatus.OK).body(StudentVO.with(updateResponse.getId(), updateResponse.getName(), updateResponse.getRegistration(), updateResponse.getCpf(),
                    updateResponse.getBirthCertificate(), updateResponse.getSerie(), updateResponse.getBirth(), updateResponse.getResponsibleId()));
        }

        logger.info("M=update, message=Controller, unable update student");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
