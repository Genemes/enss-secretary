package com.siloe.enss.infraestructure.database.student.create;

import com.siloe.enss.domain.bussiness.person.BirthCertificate;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.infraestructure.database.StudentDatabaseGateway;
import com.siloe.enss.infraestructure.mappers.BirthCertificateMapper;
import com.siloe.enss.infraestructure.mappers.StudentMapper;
import com.siloe.enss.infraestructure.presentation.BirthCertificatePresentation;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import com.siloe.enss.infraestructure.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CreateStudentDatabaseGatewayTest {

    private Student student;

    private BirthCertificate birthCertificate;

    private StudentMapper studentMapperTest;

    private BirthCertificateMapper birthCertificateMapperTest;

    private StudentPresentation studentPresentation;

    private BirthCertificatePresentation birthCertificatePresentation;
    @Mock
    private StudentMapper studentMapperMock;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentDatabaseGateway studentDatabaseGateway;

    @BeforeEach
    public void setUp(){
        studentMapperTest = new StudentMapper();
        birthCertificateMapperTest = new BirthCertificateMapper();

        birthCertificate = new BirthCertificate.Builder()
                .id(1L)
                .certificateNumber(12345678910L)
                .motherName("João Duarte Américo")
                .fatherName("Maria Silva Américo")
                .bookNumber(16)
                .bookPage(52)
                .placeOfBirth("Cajazeiras")
                .build();
        birthCertificatePresentation = birthCertificateMapperTest.mapToPresentation(birthCertificate);

        student = new Student.Builder()
                .id(6L)
                .name("Marina Silva Duarte")
                .registration("2022017")
                .cpf("718.544.364-71")
                .birthCertificate(birthCertificate)
                .serie("7")
                .birth(LocalDate.parse("2012-10-29"))
                .responsible(3L)
                .build();
        studentPresentation = studentMapperTest.mapToPresentation(student);

    }

    @Test
    public void whenGivenAValidStudentThenCreate(){
        Mockito.when(studentRepository.save(studentPresentation))
                .thenReturn(studentPresentation);
        Mockito.when(studentMapperMock.mapToPresentation(student))
                .thenReturn(studentPresentation);
        Mockito.when(studentMapperMock.presentationToMap(studentPresentation))
                .thenReturn(student);

        Student createResponse = studentDatabaseGateway.create(student);

        Assertions.assertEquals(student, createResponse);
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
