package com.ztlsir.homework.homework.Representation.model;

import com.ztlsir.shared.value.ClassAndGrade;
import lombok.Value;

import java.time.Instant;

@Value
public class HomeworkRepresentation {
    private String id;
    private ClassAndGrade classAndGrade;
    private String teacherId;
    private Instant createdAt;
    private String content;
    private String status;
}
