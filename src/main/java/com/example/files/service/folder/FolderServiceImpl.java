package com.example.files.service.folder;

import com.example.files.dto.Folder;
import com.example.files.exception.PermissionDeniedException;
import com.example.files.repository.ItemRepository;
import com.example.files.repository.entity.ItemEntity;
import com.example.files.repository.entity.enums.ItemType;
import com.example.files.repository.entity.enums.PermissionLevel;
import com.example.files.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UUID createFolder(Folder folder) {
        ItemEntity space = itemRepository.findById(folder.getSpaceId()).orElseThrow();
        boolean userHasPermissionToItem = permissionService.isUserHasPermissionToItem(folder.getUserEmail(), PermissionLevel.EDIT, space);
        if (!userHasPermissionToItem) {
            throw new PermissionDeniedException("user does not have permission for this operation");
        }
        ItemEntity item = ItemEntity.builder()
                .type(ItemType.FOLDER)
                .name(folder.getName())
                .parentItem(space)
                .permissionGroup(space.getPermissionGroup())
                .build();
        itemRepository.save(item);
        return item.getId();
    }
}
