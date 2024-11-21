package com.siloe.enss.infraestructure.repository;

import com.siloe.enss.infraestructure.presentation.PermissionPresentation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PermissionRepository extends JpaRepository<PermissionPresentation, Long> {

}
