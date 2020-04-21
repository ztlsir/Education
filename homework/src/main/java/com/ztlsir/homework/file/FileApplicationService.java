package com.ztlsir.homework.file;

import com.ztlsir.homework.file.Command.UploadImageCommand;
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

        var file = command.getFile();
        var uploadFile = File.create(
                file.getOriginalFilename(),
                new Binary(file.getBytes()),
                file.getContentType(),
                file.getSize());

        fileRepository.save(uploadFile);

        return uploadFile.getId();
    }
}
