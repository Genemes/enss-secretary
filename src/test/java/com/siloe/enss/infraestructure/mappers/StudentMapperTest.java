package com.siloe.enss.infraestructure.mappers;

import com.github.javafaker.Faker;
import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    public void setUp(){
        studentMapper = new StudentMapper();
    }

    @Test
    public void testMapFromDTOToENtity() {
        // Given
        Faker faker = new Faker(new Locale("pt-BR"));

        // Pattern: 3 digits + '.' + 3 digits + '.' + 3 digits + '-' + 2 digits
        String cpf = faker.regexify("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}");
        // Pattern: 2 digits + '.' + 3 digits + '.' + 3 digits + '-' + 1 digit
        String rg = faker.regexify("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{1}");
        int bookNumber = faker.number().numberBetween(1, 1000);
        int pageNumber = faker.number().numberBetween(1, 500);

        Date fakeDate = faker.date().birthday();
        LocalDate birth = fakeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        StudentDTO dto = new StudentDTO(
                faker.number().randomNumber(),
                faker.name().fullName(),
                String.format("Livro %d, pagina %d", bookNumber, pageNumber),
                cpf,
                faker.number().toString(),
                faker.number().toString(),
                birth,
                faker.number().randomNumber());
        // When
        Student student = studentMapper.map(dto);
        // Then
        assertNotNull(student);
        assertEquals(dto.id(), student.getId());
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
        assertEquals(student.getId(), dto.id());
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
        Faker faker = new Faker(new Locale("pt-BR"));

        // Pattern: 3 digits + '.' + 3 digits + '.' + 3 digits + '-' + 2 digits
        String cpf = faker.regexify("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}");
        // Pattern: 2 digits + '.' + 3 digits + '.' + 3 digits + '-' + 1 digit
        String rg = faker.regexify("[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{1}");
        int bookNumber = faker.number().numberBetween(1, 1000);
        int pageNumber = faker.number().numberBetween(1, 500);

        Date fakeDate = faker.date().birthday();
        LocalDate birth = fakeDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Student student = new Student.Builder()
                    .id(faker.number().randomNumber())
                    .name(faker.name().fullName())
                    .registration(String.format("Livro %d, pagina %d", bookNumber, pageNumber))
                    .cpf(cpf)
                    .birthCertificate(faker.number().toString())
                    .serie(faker.number().toString())
                    .birth(birth)
                    .responsible(faker.number().randomNumber())
                    .build();

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
}
