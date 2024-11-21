package com.siloe.enss.infraestructure.repository;

import com.siloe.enss.infraestructure.presentation.RolePresentation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RolePresentation, Long> {

}
