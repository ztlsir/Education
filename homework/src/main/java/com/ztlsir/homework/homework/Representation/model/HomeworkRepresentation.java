package com.ztlsir.homework.homework.Representation.model;

import com.ztlsir.shared.value.ClassAndGrade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.Instant;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Value
public class HomeworkRepresentation {
    private String id;
    private ClassAndGrade classAndGrade;
    private String teacherId;
    private Instant createdAt;
    private String content;
    private String status;
}
