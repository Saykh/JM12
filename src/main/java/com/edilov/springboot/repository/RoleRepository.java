package com.edilov.springboot.repository;

import com.edilov.springboot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {

}