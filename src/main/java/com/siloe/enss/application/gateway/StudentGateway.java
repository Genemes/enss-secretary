package com.siloe.enss.application.gateway;

import com.siloe.enss.domain.bussiness.person.Student;

import java.util.Optional;

public interface StudentGateway {

    Student create(Student student);
    boolean delete(Long id);

}
