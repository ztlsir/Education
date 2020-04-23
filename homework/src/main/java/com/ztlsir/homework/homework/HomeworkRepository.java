package com.ztlsir.homework.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztlsir.homework.dao.HomeworkDao;
import com.ztlsir.homework.entity.Homeworks;
import com.ztlsir.homework.homework.model.Homework;
import com.ztlsir.shared.model.BaseRepository;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class HomeworkRepository extends BaseRepository<Homework> {
    private final HomeworkDao homeworkDao;
    private final ObjectMapper objectMapper;

    public HomeworkRepository(HomeworkDao homeworkDao, ObjectMapper objectMapper) {
        this.homeworkDao = homeworkDao;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    protected void doSave(Homework homework) {
        homeworkDao.save(new Homeworks(homework.getId(), objectMapper.writeValueAsString(homework)));
    }

    @SneakyThrows
    public Homework byId(String id) {
        var homeworkDB = homeworkDao.findById(id).get();
        return objectMapper.readValue(homeworkDB.getJsonContent(), Homework.class);
    }
}
