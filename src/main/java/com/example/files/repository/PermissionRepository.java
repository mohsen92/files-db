package com.example.files.repository;

import com.example.files.repository.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, UUID> {
    List<PermissionEntity> findByUserEmailAndPermissionGroupId(String userEmail, UUID permissionGroupId);
}
