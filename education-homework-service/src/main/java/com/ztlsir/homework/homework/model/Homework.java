package com.ztlsir.homework.homework.model;

import com.ztlsir.homework.homework.representation.HomeworkRepresentation;
import com.ztlsir.shared.model.BaseAggregate;
import com.ztlsir.shared.value.ClassAndGrade;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

import static java.time.Instant.now;

@Getter
@Builder
public class Homework extends BaseAggregate {
    private String id;
    private ClassAndGrade classAndGrade;
    private String teacherId;
    private Instant createdAt;
    private String content;
    private HomeworkStatus status;

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
                .status(HomeworkStatus.EDIT)
                .build();
        return homework;
    }

    public HomeworkRepresentation toRepresentation() {
        return new HomeworkRepresentation(
                this.getId(),
                this.getClassAndGrade(),
                this.getTeacherId(),
                this.getCreatedAt(),
                this.getContent(),
                this.getStatus().name()
        );
    }
}
