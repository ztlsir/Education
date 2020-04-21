package com.ztlsir.homework.file;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    private final  FileApplicationService fileApplicationService;

    public FileController(FileApplicationService fileApplicationService) {
        this.fileApplicationService = fileApplicationService;
    }

    @SneakyThrows
    @PostMapping("/upload/image")
    @ResponseStatus(CREATED)
    public Map<String, String> uploadImage(@RequestParam(value = "image") MultipartFile file) {
        return of("id", fileApplicationService.saveImage(file));
    }
}
