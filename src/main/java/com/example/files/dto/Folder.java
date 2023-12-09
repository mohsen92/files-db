package com.example.files.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Folder {
    private String name;
    private UUID spaceId;
    private String userEmail;
}
