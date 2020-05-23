package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.command.CreateCommand;
import com.ztlsir.homework.homework.model.HomeworkFactory;
import com.ztlsir.homework.homework.repository.HomeworkRepository;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class HomeworkApplicationService {
    private HomeworkFactory homeworkFactory;
    private HomeworkRepository homeworkRepository;

    public HomeworkApplicationService(HomeworkFactory homeworkFactory, HomeworkRepository homeworkRepository) {
        this.homeworkFactory = homeworkFactory;
        this.homeworkRepository = homeworkRepository;
    }

    public String create(CreateCommand command) {
        var homework = homeworkFactory.create(command.classAndGrade, command.teacherId, command.content);
        homeworkRepository.save(homework);

        return homework.getId();
    }
}
