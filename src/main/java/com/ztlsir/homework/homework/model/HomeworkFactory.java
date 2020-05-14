package com.ztlsir.homework.homework.model;

import com.ztlsir.shared.value.ClassAndGrade;
import org.springframework.stereotype.Component;

@Component
public class HomeworkFactory {
    private final HomeworkIdGenerator idGenerator;

    public HomeworkFactory(HomeworkIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Homework create(ClassAndGrade classAndGrade, String teacherId, String content) {
        String homeworkId = idGenerator.generate();
        return Homework.create(homeworkId,classAndGrade,teacherId,content);
    }
}
