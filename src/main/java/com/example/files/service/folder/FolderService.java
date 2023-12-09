package com.example.files.service.folder;

import com.example.files.dto.Folder;
import com.example.files.dto.Space;

import java.util.UUID;

public interface FolderService {
    UUID createFolder(Folder folder);

}
