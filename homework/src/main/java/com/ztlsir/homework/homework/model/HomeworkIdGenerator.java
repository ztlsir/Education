package com.ztlsir.homework.homework.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HomeworkIdGenerator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
