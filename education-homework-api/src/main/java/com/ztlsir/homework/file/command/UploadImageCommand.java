package com.ztlsir.homework.file.command;

import com.ztlsir.shared.validation.ImageCheck;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class UploadImageCommand {
    @NotNull
    @ImageCheck(message = "请上传正确的图片")
    private MultipartFile multipartFile;
}
