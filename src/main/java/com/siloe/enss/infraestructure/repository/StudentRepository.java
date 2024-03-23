package com.siloe.enss.infraestructure.repository;

import com.siloe.enss.domain.bussiness.person.Student;
import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentPresentation, UUID> {

    Optional<StudentPresentation> findByCpf (String cpf);

}
