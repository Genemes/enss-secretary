package com.siloe.enss.infraestructure.database.student.delete;

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
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DeleteStudentDatabaseGatewayTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentDatabaseGateway studentDatabaseGateway;

    private StudentMapper studentMapper;

    private Student student;
    private BirthCertificateMapper birthCertificateMapperTest;

    private BirthCertificate birthCertificate;

    private BirthCertificatePresentation birthCertificatePresentation;

    @BeforeEach
    public void setup(){
        birthCertificateMapperTest = new BirthCertificateMapper();
        studentMapper = new StudentMapper();

        birthCertificate = new BirthCertificate.Builder()
                .id(1L)
                .certificateNumber(12345678910L)
                .motherName("João Duarte Américo")
                .fatherName("Maria Silva Américo")
                .bookNumber(16)
                .bookPage(52)
                .placeOfBirth("Cajazeiras")
                .build();
        birthCertificatePresentation =
                birthCertificateMapperTest.mapToPresentation(birthCertificate);

        student = new Student.Builder()
                .id(5L)
                .name("José Junior da Silva")
                .registration("2024001")
                .cpf("709.547.963-70")
                .birthCertificate(birthCertificate)
                .serie("8")
                .birth(LocalDate.parse("2011-02-16"))
                .responsible(1L)
                .build();

    }

    @Test
    public void whenGivenAValidIdThenDelete() {
        Optional<StudentPresentation> studentPresentation
                = Optional.of(studentMapper.mapToPresentation(student));

        Mockito.when(studentRepository.findById(student.getId())).thenReturn(studentPresentation);
        Mockito.doNothing().when(studentRepository).delete(studentPresentation.get());

        boolean response = studentDatabaseGateway.delete(student.getId());

        Mockito.verify(studentRepository, Mockito.times(1))
                .findById(student.getId());

        Mockito.verify(studentRepository, Mockito.times(1))
                .delete(studentPresentation.get());

        Assertions.assertTrue(response);
    }

    @Test
    public void whenGivenANullIdThenThrowAnException(){
        Optional<StudentPresentation> studentPresentation
                = Optional.of(studentMapper.mapToPresentation(student));

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
            boolean response = studentDatabaseGateway.delete(null);
            Assertions.assertFalse(response);
        });

        Assertions.assertEquals(exception.getMessage(), "Id cannot be null!");
        Mockito.verify(studentRepository, Mockito.times(0))
                .findById(student.getId());

        Mockito.verify(studentRepository, Mockito.times(0))
                .delete(studentPresentation.get());
    }

    @Test
    public void whenGivenAInvalidIdThenDoNotDelete(){
        Optional<StudentPresentation> studentPresentation
                = Optional.of(studentMapper.mapToPresentation(student));

        Mockito.when(studentRepository.findById(6L)).thenReturn(Optional.empty());

        boolean response = studentDatabaseGateway.delete(6L);

        Mockito.verify(studentRepository, Mockito.times(1)).findById(6L);
        Mockito.verify(studentRepository, Mockito.times(0)).delete(Mockito.any());
        Assertions.assertFalse(response);
    }
}
