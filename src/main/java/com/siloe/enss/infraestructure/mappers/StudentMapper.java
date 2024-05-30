package com.siloe.enss.infraestructure.mappers;

import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.domain.dto.StudentDTO;
import com.siloe.enss.infraestructure.presentation.BirthCertificatePresentation;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private BirthCertificateMapper birthCertificateMapper;

    public StudentMapper(){
        this.birthCertificateMapper = new BirthCertificateMapper();
    }
    public Student map(StudentDTO studentDTO){
        return new Student.Builder()
                .name(studentDTO.name())
                .registration(studentDTO.registration())
                .cpf(studentDTO.cpf())
                .birthCertificate(birthCertificateMapper.dtoToMap(studentDTO.birthCertificate()))
                .serie(studentDTO.serie())
                .birth(studentDTO.birth())
                .responsible(studentDTO.responsibleId())
                .build();
    }

    public Student presentationToMap(StudentPresentation studentPresentation){
        return new Student.Builder()
                .id(studentPresentation.getId())
                .name(studentPresentation.getName())
                .registration(studentPresentation.getRegistration())
                .birthCertificate(birthCertificateMapper
                        .presentationToMap(studentPresentation.getBirthCertificate()))
                .cpf(studentPresentation.getCpf())
                .serie(studentPresentation.getSerie())
                .birth(studentPresentation.getBirth())
                .responsible(studentPresentation.getResponsible())
                .build();
    }

    public StudentDTO map(Student student){
        return new StudentDTO(student.getName(), student.getRegistration(), student.getCpf(),
                birthCertificateMapper.mapToDto(student.getBirthCertificate()),
                student.getSerie(), student.getBirth(), student.getResponsibleId());
    }

    public StudentPresentation mapToPresentation(Student student) {
        return new StudentPresentation.Builder()
                .id(student.getId())
                .name(student.getName())
                .registration(student.getRegistration())
                .birthCertificate(birthCertificateMapper
                        .mapToPresentation(student.getBirthCertificate()))
                .cpf(student.getCpf())
                .serie(student.getSerie())
                .birth(student.getBirth())
                .responsibleId(student.getResponsibleId())
                .build();
    }

}
