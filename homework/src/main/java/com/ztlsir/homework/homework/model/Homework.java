package com.ztlsir.homework.homework.model;

import com.ztlsir.shared.model.ClassAndGrade;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

import static java.time.Instant.now;

@Getter
@Builder
public class Homework {
    private String id;
    private ClassAndGrade classAndGrade;
    private String teacherId;
    private Instant createdAt;
    private String content;

    public static Homework create(
            String id,
            ClassAndGrade classAndGrade,
            String teacherId,
            String content) {
        Homework homework = Homework.builder()
                .id(id)
                .classAndGrade(classAndGrade)
                .teacherId(teacherId)
                .createdAt(now())
                .content(content)
                .build();
        return homework;
    }
}
