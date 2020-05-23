package com.ztlsir.homework.file.representation;

import lombok.Value;

@Value
public class FileRepresentation {
    private String name;
    private byte[] content;
    private String contentType;
    private long size;
}
