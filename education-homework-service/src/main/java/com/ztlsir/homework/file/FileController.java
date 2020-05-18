package com.ztlsir.homework.file;

import com.ztlsir.homework.file.Command.UploadImageCommand;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@RestController
public class FileController implements FileClient {

    private final FileApplicationService fileApplicationService;
    private final FileRepresentationService fileRepresentationService;

    public FileController(
            FileApplicationService fileApplicationService,
            FileRepresentationService fileRepresentationService) {
        this.fileApplicationService = fileApplicationService;
        this.fileRepresentationService = fileRepresentationService;
    }

    @SneakyThrows
    @Override
    public Map<String, String> uploadImage(@Valid UploadImageCommand uploadImageCommand) {
        return of("id", fileApplicationService.saveImage(uploadImageCommand));
    }

    @Override
    public byte[] image(@PathVariable(name = "id") String id) {
        return fileRepresentationService
                .GetById(id)
                .getContent();
    }
}
