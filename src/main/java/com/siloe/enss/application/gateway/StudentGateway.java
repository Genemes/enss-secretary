package com.siloe.enss.application.gateway;

import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;

import java.util.Optional;

public interface StudentGateway {

    Student create(Student student);
    boolean delete(Long id);

    Student update(Student student, Long id);

}
