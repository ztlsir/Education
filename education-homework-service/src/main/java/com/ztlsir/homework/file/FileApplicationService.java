package com.ztlsir.homework.file;

import com.ztlsir.homework.file.command.UploadImageCommand;
import com.ztlsir.homework.file.model.File;
import lombok.SneakyThrows;
import lombok.var;
import org.bson.types.Binary;
import org.springframework.stereotype.Component;

@Component
public class FileApplicationService {
    private final FileRepository fileRepository;

    public FileApplicationService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @SneakyThrows
    public String saveImage(UploadImageCommand command) {

        var multipartFile = command.getMultipartFile();
        var uploadFile = File.create(
                multipartFile.getOriginalFilename(),
                new Binary(multipartFile.getBytes()),
                multipartFile.getContentType(),
                multipartFile.getSize());

        fileRepository.save(uploadFile);

        return uploadFile.getId();
    }
}
