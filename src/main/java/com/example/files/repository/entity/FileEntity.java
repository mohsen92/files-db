package com.example.files.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.usertype.UserType;

import java.sql.Types;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "file")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Lob
    @Column(name="data")
    @JdbcTypeCode(Types.VARBINARY)
    private byte[] binary;

    @Column(name = "content_type")
    private String contentType;

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private ItemEntity item;
}
