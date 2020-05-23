package com.ztlsir.homework.file.representation;

import com.ztlsir.homework.file.FileRepository;
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
