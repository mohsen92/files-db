package com.example.files.service.permission;

import com.example.files.repository.PermissionRepository;
import com.example.files.repository.entity.ItemEntity;
import com.example.files.repository.entity.enums.PermissionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public boolean isUserHasPermissionToItem(String userEmail, PermissionLevel permissionLevel, ItemEntity item) {
        return permissionRepository.findByUserEmailAndPermissionGroupId(userEmail, item.getPermissionGroup().getId())
                .stream()
                .anyMatch(permissionEntity -> permissionEntity.getPermissionLevel() == permissionLevel);

    }
}
