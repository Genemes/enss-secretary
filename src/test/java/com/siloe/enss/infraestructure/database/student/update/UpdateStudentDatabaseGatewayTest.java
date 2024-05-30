package com.siloe.enss.infraestructure.database.student.update;

import com.siloe.enss.domain.bussiness.person.BirthCertificate;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.infraestructure.database.StudentDatabaseGateway;
import com.siloe.enss.infraestructure.mappers.StudentMapper;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import com.siloe.enss.infraestructure.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UpdateStudentDatabaseGatewayTest {


    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper mapper;

    @InjectMocks
    private StudentDatabaseGateway studentDatabaseGateway;

    private StudentMapper studentMapper;

    private BirthCertificate birthCertificate;

    private Student originalStudent;

    private Student updatedStudent;

    private StudentPresentation originalStudentPresentation;

    private StudentPresentation updatedStudentPresentation;

    @BeforeEach
    public void setUp(){
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

        originalStudent = new Student.Builder()
                .id(58L)
                .name("Gabriel dos Santos")
                .registration("2024002")
                .cpf("799.521.742-48")
                .birthCertificate(birthCertificate)
                .serie("7")
                .birth(LocalDate.parse("2011-08-25"))
                .responsible(2L)
                .build();

        updatedStudent = originalStudent;
        updatedStudent.setName(updatedStudent.getName() + " Silveira");

        originalStudentPresentation = studentMapper.mapToPresentation(originalStudent);
        updatedStudentPresentation = studentMapper.mapToPresentation(updatedStudent);
    }

    @Test
    public void whenGivenAValidStudentAndIdThenUpdate(){
        long idToUpdate = 58;

        Mockito.when(studentRepository.findById(idToUpdate))
                .thenReturn(Optional.of(originalStudentPresentation));
        Mockito.when(studentRepository.save(updatedStudentPresentation))
                .thenReturn(updatedStudentPresentation);
        Mockito.when(mapper.presentationToMap(updatedStudentPresentation))
                .thenReturn(updatedStudent);

        Student updateStudentResponse = studentDatabaseGateway.update(updatedStudent, idToUpdate);

        Assertions.assertEquals(updateStudentResponse, updatedStudent);
        Mockito.verify(studentRepository, Mockito.times(1))
                .findById(idToUpdate);
        Mockito.verify(studentRepository, Mockito.times(1))
                .save(updatedStudentPresentation);
    }

    @Test
    public void whenGivenAValidStudentAndNullIdThenThrow(){
        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
            studentDatabaseGateway.update(originalStudent, null);
        });

        Assertions.assertEquals(exception.getMessage(), "Id cannot be null");
        Mockito.verifyNoMoreInteractions(studentRepository);
    }

    @Test
    public void whenGivenANullStudentAndNonNullIdThenThrow(){
        long idToUpdate = 58;

        NullPointerException exception = Assertions.assertThrows(NullPointerException.class, () -> {
            studentDatabaseGateway.update(null, idToUpdate);
        });

        Assertions.assertEquals(exception.getMessage(), "Student cannot be null");
        Mockito.verifyNoMoreInteractions(studentRepository);
    }

    @Test
    public void whenGivenAValidStudentAndANonExistentIdThenDontUpdate(){
        long idToUpdate = 781;

        Mockito.when(studentRepository.findById(idToUpdate)).thenReturn(Optional.empty());

        studentDatabaseGateway.update(updatedStudent, idToUpdate);

        Mockito.verify(studentRepository, Mockito.times(0)).save(Mockito.any());
    }
}
