package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.command.CreateCommand;
import com.ztlsir.homework.homework.model.HomeworkFactory;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class HomeworkApplicationService {
    private HomeworkFactory homeworkFactory;

    public HomeworkApplicationService(HomeworkFactory homeworkFactory) {
        this.homeworkFactory = homeworkFactory;
    }

    public String create(CreateCommand command) {
        var homework = homeworkFactory.create(command.classAndGrade, command.teacherId, command.content);

        return homework.getId();
    }
}
