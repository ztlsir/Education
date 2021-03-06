package com.ztlsir.homework.file.model;

import com.ztlsir.homework.file.representation.FileRepresentation;
import com.ztlsir.shared.model.BaseAggregate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Builder
@Document
public class File extends BaseAggregate {
    @Id
    private String id;
    private String name;
    private Binary content;
    private String contentType;
    private long size;

    public static File create(String name, Binary content, String contentType, long size) {
        return File.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .content(content)
                .contentType(contentType)
                .size(size)
                .build();
    }

    public FileRepresentation toRepresentation() {
        return new FileRepresentation(
                this.getName(),
                this.getContent().getData(),
                this.getContentType(),
                this.getSize());
    }
}
