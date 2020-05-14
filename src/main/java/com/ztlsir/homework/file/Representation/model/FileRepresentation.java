package com.ztlsir.homework.file.Representation.model;

import lombok.Value;

@Value
public class FileRepresentation {
    private String name;
    private byte[] content;
    private String contentType;
    private long size;
}
