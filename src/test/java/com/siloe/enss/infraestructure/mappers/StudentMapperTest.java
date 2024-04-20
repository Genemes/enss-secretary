package com.siloe.enss.infraestructure.mappers;

import com.github.javafaker.Faker;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class StudentMapperTest {

    private static final Locale LOCALE_PT_BR = new Locale("pt-BR");
    private static final String CPF_PATTERN = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
    private static final String RG_PATTERN = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{1}";

    private StudentMapper studentMapper;
    private Faker faker;

    @BeforeEach
    public void setUp() {
        studentMapper = new StudentMapper();
        faker = new Faker(LOCALE_PT_BR);
    }

    private StudentDTO createFakeStudentDTO() {
        String cpf = faker.regexify(CPF_PATTERN);
        String rg = faker.regexify(RG_PATTERN);
        int bookNumber = faker.number().numberBetween(1, 1000);
        int pageNumber = faker.number().numberBetween(1, 500);
        Date fakeDate = faker.date().birthday();
        LocalDate birth = fakeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new StudentDTO(
                faker.name().fullName(),
                String.format("Livro %d, pagina %d", bookNumber, pageNumber),
                cpf,
                faker.number().toString(),
                faker.number().toString(),
                birth,
                faker.number().randomNumber());
    }

    private Student createFakeStudent() {
        String cpf = faker.regexify(CPF_PATTERN);
        String rg = faker.regexify(RG_PATTERN);
        int bookNumber = faker.number().numberBetween(1, 1000);
        int pageNumber = faker.number().numberBetween(1, 500);
        Date fakeDate = faker.date().birthday();
        LocalDate birth = fakeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new Student.Builder()
                .id(faker.number().randomNumber())
                .name(faker.name().fullName())
                .registration(String.format("Livro %d, pagina %d", bookNumber, pageNumber))
                .cpf(cpf)
                .birthCertificate(faker.number().toString())
                .serie(faker.number().toString())
                .birth(birth)
                .responsible(faker.number().randomNumber())
                .build();
    }

    @Test
    public void testMapFromDTOToENtity() {
        // Given
        StudentDTO dto = createFakeStudentDTO();

        // When
        Student student = studentMapper.map(dto);

        // Then
        assertNotNull(student);
        assertEquals(dto.name(), student.getName());
        assertEquals(dto.registration(), student.getRegistration());
        assertEquals(dto.cpf(), student.getCpf());
        assertEquals(dto.birthCertificate(), student.getBirthCertificate());
        assertEquals(dto.serie(), student.getSerie());
        assertEquals(dto.birth(), student.getBirth());
        assertEquals(dto.responsibleId(), student.getResponsibleId());
    }

    @Test
    public void testMapFromEntityToDTO() {
        // Given
        Student student = new Student.Builder().build();

        // When
        StudentDTO dto = studentMapper.map(student);

        // Then
        assertNotNull(dto);
        assertEquals(student.getName(), dto.name());
        assertEquals(student.getRegistration(), dto.registration());
        assertEquals(student.getCpf(), dto.cpf());
        assertEquals(student.getBirthCertificate(), dto.birthCertificate());
        assertEquals(student.getSerie(), dto.serie());
        assertEquals(student.getBirth(), dto.birth());
        assertEquals(student.getResponsibleId(), dto.responsibleId());
    }

    @Test
    public void testMapToPresentation() {
        // Given
        Student student = createFakeStudent();

        // When
        StudentPresentation presentation = studentMapper.mapToPresentation(student);

        // Then
        assertNotNull(presentation);
        assertEquals(student.getId(), presentation.getId());
        assertEquals(student.getName(), presentation.getName());
        assertEquals(student.getRegistration(), presentation.getRegistration());
        assertEquals(student.getCpf(), presentation.getCpf());
        assertEquals(student.getBirthCertificate(), presentation.getBirthCertificate());
        assertEquals(student.getSerie(), presentation.getSerie());
        assertEquals(student.getBirth(), presentation.getBirth());
        assertEquals(student.getResponsibleId(), presentation.getResponsible());
    }

    @Test
    public void testPresentationToMap(){
        Student student = createFakeStudent();
        StudentPresentation studentPresentation = studentMapper.mapToPresentation(student);

        Student mappedStudent = studentMapper.presentationToMap(studentPresentation);

        assertNotNull(mappedStudent);
        assertEquals(student.getId(), mappedStudent.getId());
        assertEquals(student.getName(), mappedStudent.getName());
        assertEquals(student.getRegistration(), mappedStudent.getRegistration());
        assertEquals(student.getCpf(), mappedStudent.getCpf());
        assertEquals(student.getBirthCertificate(), mappedStudent.getBirthCertificate());
        assertEquals(student.getSerie(), mappedStudent.getSerie());
        assertEquals(student.getBirth(), mappedStudent.getBirth());
        assertEquals(student.getResponsibleId(), mappedStudent.getResponsibleId());

    }
}
