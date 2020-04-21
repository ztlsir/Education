package com.ztlsir.homework.file.Command;

import com.ztlsir.shared.validation.ImageCheck;
import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Value
public class UploadImageCommand {
    @NotNull
    @ImageCheck(message = "请上传正确的图片")
    private MultipartFile file;
}
