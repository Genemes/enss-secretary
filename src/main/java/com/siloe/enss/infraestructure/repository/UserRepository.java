package com.siloe.enss.infraestructure.repository;

import com.siloe.enss.infraestructure.presentation.AccountPresentation;
import com.siloe.enss.infraestructure.presentation.EmailPresentation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<AccountPresentation, Long> {

    Optional<AccountPresentation> findByEmail (EmailPresentation email);
    Optional<AccountPresentation> findByUsername (String email);

}
