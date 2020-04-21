package com.ztlsir.homework.file;

import com.ztlsir.homework.file.model.File;
import lombok.SneakyThrows;
import lombok.var;
import org.bson.types.Binary;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class FileApplicationService {
    private final FileRepository fileRepository;

    public FileApplicationService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @SneakyThrows
    public String saveImage(MultipartFile file) {

        var uploadFile = File.create(
                file.getOriginalFilename(),
                new Binary(file.getBytes()),
                file.getContentType(),
                file.getSize());

        fileRepository.save(uploadFile);

        return uploadFile.getId();
    }
}
