package com.siloe.enss.infraestructure.database.student.create;

import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.infraestructure.database.StudentDatabaseGateway;
import com.siloe.enss.infraestructure.mappers.StudentMapper;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import com.siloe.enss.infraestructure.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

public class CreateStudentDatabaseGatewayTest {

    private Student student;

    private StudentMapper studentMapperTest;

    private StudentPresentation studentPresentation;
    @Mock
    private StudentMapper studentMapperMock;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentDatabaseGateway studentDatabaseGateway;

    @BeforeEach
    public void setUp(){

        this.student = new Student.Builder()
                .id(6L)
                .name("Marina Silva Duarte")
                .registration("2022017")
                .cpf("718.544.364-71")
                .birthCertificate("19244303551019161155997790743220")
                .serie("7")
                .birth(LocalDate.parse("2012-10-29"))
                .responsible(3L)
                .build();
        this.studentMapperTest = new StudentMapper();
        this.studentPresentation = studentMapperTest.mapToPresentation(student);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void whenGivenAValidStudentThenCreate(){
        Mockito.when(studentRepository.save(studentPresentation))
                .thenReturn(studentPresentation);
        Mockito.when(studentMapperMock.mapToPresentation(student))
                .thenReturn(studentPresentation);

        Student createResponse = studentDatabaseGateway.create(student);

        Assertions.assertEquals(createResponse, student);
        Mockito.verify(studentRepository,
                Mockito.times(1)).save(studentPresentation);
        Mockito.verifyNoMoreInteractions(studentRepository);
    }

    @Test
    public void whenGivenAnInvalidStudentThenThrow(){
        Student studentTest = null;

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
            studentDatabaseGateway.create(studentTest);
        });

        Assertions.assertEquals(exception.getMessage(), "Student cannot be null");
        Assertions.assertEquals(exception.getClass(), NullPointerException.class);
    }

}
