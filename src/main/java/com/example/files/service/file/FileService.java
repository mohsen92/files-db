package com.example.files.service.file;

import com.example.files.dto.FileMetadata;
import com.example.files.repository.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface FileService {
    UUID createFile(UUID folderId, MultipartFile file, String userEmail) throws IOException;

    FileEntity downloadFile(UUID fileId);

    FileMetadata viewFileMetadata(UUID fileId);

}
