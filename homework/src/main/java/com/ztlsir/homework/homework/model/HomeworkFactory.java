package com.ztlsir.homework.homework.model;

import com.ztlsir.shared.model.ClassAndGrade;
import org.springframework.stereotype.Component;

@Component
public class HomeworkFactory {
    private final HomeworkIdGenerator idGenerator;

    public HomeworkFactory(HomeworkIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Homework create(ClassAndGrade classAndGrade, String teacherId) {
        String homeworkId = idGenerator.generate();
        return Homework.create(homeworkId,classAndGrade,teacherId);
    }
}
