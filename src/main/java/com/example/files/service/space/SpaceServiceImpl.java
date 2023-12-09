package com.example.files.service.space;

import com.example.files.dto.Space;
import com.example.files.repository.ItemRepository;
import com.example.files.repository.entity.ItemEntity;
import com.example.files.repository.entity.PermissionGroupEntity;
import com.example.files.repository.entity.PermissionGroupRepository;
import com.example.files.repository.entity.enums.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PermissionGroupRepository permissionGroupRepository;

    @Override
    public UUID createSpace(Space space) {
        PermissionGroupEntity permissionGroup = permissionGroupRepository.findById(space.getGroupId()).orElseThrow();
        ItemEntity item = ItemEntity.builder().type(ItemType.SPACE).name(space.getName()).permissionGroup(permissionGroup).build();
        itemRepository.save(item);
        return item.getId();
    }
}
