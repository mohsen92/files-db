package com.example.files.web;

import com.example.files.dto.Space;
import com.example.files.service.space.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @PostMapping("spaces")
    public ResponseEntity<Void> createSpace(@RequestBody Space space) {
        UUID id = spaceService.createSpace(space);
        return ResponseEntity.created(URI.create("spaces/" + id)).build();
    }
}
