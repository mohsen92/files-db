package com.example.files.repository;

import com.example.files.dto.FileMetadata;
import com.example.files.repository.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, UUID> {

    @Query(nativeQuery = true,
            value = "select fi.id as id, it.name as fileName, fi.content_type as contentType " +
                    "from file fi, item it " +
                    "where fi.id = :fileId and fi.item_id = it.id")
    FileMetadata findFileMetaData(@Param("fileId") UUID fileId);

}
