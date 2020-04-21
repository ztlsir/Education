package com.ztlsir.homework.file;

import com.ztlsir.homework.file.Command.UploadImageCommand;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    private final FileApplicationService fileApplicationService;
    private final FileRepresentationService fileRepresentationService;

    public FileController(
            FileApplicationService fileApplicationService,
            FileRepresentationService fileRepresentationService) {
        this.fileApplicationService = fileApplicationService;
        this.fileRepresentationService = fileRepresentationService;
    }

    @SneakyThrows
    @PostMapping("/upload/image")
    @ResponseStatus(CREATED)
    public Map<String, String> uploadImage(@Valid UploadImageCommand uploadImageCommand) {
        return of("id", fileApplicationService.saveImage(uploadImageCommand));
    }

    @GetMapping(value = "/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable(name = "id") String id) {
        return fileRepresentationService
                .GetById(id)
                .getContent();
    }
}
