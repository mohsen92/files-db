package com.example.files.web;

import com.example.files.dto.Folder;
import com.example.files.service.folder.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class FolderController {

    @Autowired
    private FolderService folderService;

    @PostMapping("folders")
    public ResponseEntity<Void> createFolder(@RequestBody Folder folder) {
        UUID id = folderService.createFolder(folder);
        return ResponseEntity.created(URI.create("folders/" + id)).build();
    }
}
