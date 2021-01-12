package com.example.ecommerce.repository;


import com.example.ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
  Role findByRoleName(String role_name);
}
