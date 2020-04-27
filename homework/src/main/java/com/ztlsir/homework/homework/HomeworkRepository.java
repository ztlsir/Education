package com.ztlsir.homework.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztlsir.homework.dao.HomeworkDao;
import com.ztlsir.homework.entity.Homework;
import com.ztlsir.shared.model.BaseRepository;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class HomeworkRepository extends BaseRepository<com.ztlsir.homework.homework.model.Homework> {
    private final HomeworkDao homeworkDao;
    private final ObjectMapper objectMapper;

    public HomeworkRepository(HomeworkDao homeworkDao, ObjectMapper objectMapper) {
        this.homeworkDao = homeworkDao;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    protected void doSave(com.ztlsir.homework.homework.model.Homework homework) {
        homeworkDao.save(new Homework(homework.getId(), objectMapper.writeValueAsString(homework)));
    }

    @SneakyThrows
    public com.ztlsir.homework.homework.model.Homework byId(String id) {
        var homeworkDB = homeworkDao.findById(id).get();
        return objectMapper.readValue(homeworkDB.getJsonContent(), com.ztlsir.homework.homework.model.Homework.class);
    }
}
