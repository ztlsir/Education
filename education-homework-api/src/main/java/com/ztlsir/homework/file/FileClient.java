package com.ztlsir.homework.file;

import com.ztlsir.homework.file.Command.UploadImageCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@FeignClient("homework-service")
@RequestMapping(value = "/files")
public interface FileClient {
    @PostMapping("/upload/image")
    @ResponseStatus(CREATED)
    public Map<String, String> uploadImage(UploadImageCommand uploadImageCommand);

    @GetMapping(value = "/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable(name = "id") String id);
}
