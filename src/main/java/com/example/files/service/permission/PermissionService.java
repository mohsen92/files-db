package com.example.files.service.permission;

import com.example.files.repository.entity.ItemEntity;
import com.example.files.repository.entity.enums.PermissionLevel;

public interface PermissionService {
    boolean isUserHasPermissionToItem(String userName, PermissionLevel permissionLevel, ItemEntity space);
}
