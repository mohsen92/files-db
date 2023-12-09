package com.example.files.service.file;

import com.example.files.dto.FileMetadata;
import com.example.files.exception.PermissionDeniedException;
import com.example.files.repository.FileRepository;
import com.example.files.repository.ItemRepository;
import com.example.files.repository.entity.FileEntity;
import com.example.files.repository.entity.ItemEntity;
import com.example.files.repository.entity.enums.ItemType;
import com.example.files.repository.entity.enums.PermissionLevel;
import com.example.files.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UUID createFile(UUID folderId, MultipartFile multipartFile, String userEmail) throws IOException {
        ItemEntity folder = itemRepository.findById(folderId).orElseThrow();
        boolean userHasPermissionToItem = permissionService.isUserHasPermissionToItem(userEmail, PermissionLevel.EDIT, folder);
        if (!userHasPermissionToItem) {
            throw new PermissionDeniedException("user does not have permission for this operation");
        }
        ItemEntity item = ItemEntity.builder().type(ItemType.FILE).name(multipartFile.getOriginalFilename()).parentItem(folder).permissionGroup(folder.getPermissionGroup()).build();
        itemRepository.save(item);
        FileEntity file = FileEntity.builder().item(item).contentType(multipartFile.getContentType()).binary(multipartFile.getBytes()).build();
        fileRepository.save(file);
        return file.getId();
    }

    @Override
    public FileEntity downloadFile(UUID fileId) {
        return fileRepository.findById(fileId).orElseThrow();
    }

    @Override
    public FileMetadata viewFileMetadata(UUID fileId) {
        return fileRepository.findFileMetaData(fileId);
    }
}
