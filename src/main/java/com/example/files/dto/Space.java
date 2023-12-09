package com.example.files.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Space {
    private String name;
    private UUID groupId;
}
