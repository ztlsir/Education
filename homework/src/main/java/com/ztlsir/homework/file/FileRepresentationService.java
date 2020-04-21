package com.ztlsir.homework.file;

import com.ztlsir.homework.file.Representation.model.FileRepresentation;
import lombok.var;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class FileRepresentationService {
    private final FileRepository fileRepository;

    public FileRepresentationService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public FileRepresentation GetById(String id) {
        return fileRepository
                .GetById(id)
                .toRepresentation();
    }
}
