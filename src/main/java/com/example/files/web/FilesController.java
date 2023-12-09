package com.example.files.web;

import com.example.files.dto.FileMetadata;
import com.example.files.repository.entity.FileEntity;
import com.example.files.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class FilesController {

    @Autowired
    private FileService fileService;

    @QueryMapping
    public FileMetadata findFileMetadata(@Argument UUID fileId) {
        return fileService.viewFileMetadata(fileId);
    }

    @GetMapping("files/{fileId}/metadata")
    public FileMetadata viewFileMetadata(@PathVariable("fileId") UUID fileId) {
        return fileService.viewFileMetadata(fileId);
    }

    @PostMapping("folders/{folderId}/files")
    public ResponseEntity<Void> createFile(@RequestParam("file") MultipartFile file,
                                           @RequestParam("userEmail") String userEmail,
                                           @PathVariable("folderId") UUID folderId) throws IOException {
        UUID id = fileService.createFile(folderId, file, userEmail);
        return ResponseEntity.created(URI.create("files/" + id)).build();
    }

    @GetMapping(
            path = "files/{fileId}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public @ResponseBody ResponseEntity<byte[]> downLoadFile(@PathVariable("fileId") UUID fileId) {
        FileEntity fileEntity = fileService.downloadFile(fileId);
        MediaType contentType = MediaType.parseMediaType(fileEntity.getContentType());
        return ResponseEntity.ok()
                .contentType(contentType)
                .body(fileEntity.getBinary());
    }


}
