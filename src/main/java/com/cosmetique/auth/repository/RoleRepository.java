package com.cosmetique.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosmetique.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
