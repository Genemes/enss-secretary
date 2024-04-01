package com.siloe.enss.infraestructure.repository;

import com.siloe.enss.infraestructure.presentation.StudentPresentation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<StudentPresentation, Long> {

    Optional<StudentPresentation> findByCpf (String cpf);

}
