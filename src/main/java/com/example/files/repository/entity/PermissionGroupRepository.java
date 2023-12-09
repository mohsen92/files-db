package com.example.files.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroupEntity, UUID> {

}
