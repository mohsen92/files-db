package com.example.files.repository.entity;

import com.example.files.repository.entity.enums.ItemType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ItemType type;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_item_id", referencedColumnName = "id")
    private ItemEntity parentItem;

    @ManyToOne
    @JoinColumn(name = "permission_group_id", referencedColumnName = "id")
    private PermissionGroupEntity permissionGroup;

}
