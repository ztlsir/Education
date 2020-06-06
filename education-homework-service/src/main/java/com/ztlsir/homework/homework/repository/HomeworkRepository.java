package com.ztlsir.homework.homework.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztlsir.homework.homework.model.Homework;
import com.ztlsir.shared.event.DomainEventSender;
import com.ztlsir.shared.model.BaseRepository;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.stereotype.Component;

@Component
public class HomeworkRepository extends BaseRepository<Homework> {
    private final HomeworkDao homeworkDao;
    private final ObjectMapper objectMapper;

    public HomeworkRepository(
            HomeworkDao homeworkDao,
            ObjectMapper objectMapper,
            DomainEventSender sender) {
        super(sender);
        this.homeworkDao = homeworkDao;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @Override
    protected void doSave(com.ztlsir.homework.homework.model.Homework homework) {
        homeworkDao.save(new HomeworkPO(homework.getId(), objectMapper.writeValueAsString(homework)));
    }

    @SneakyThrows
    public com.ztlsir.homework.homework.model.Homework byId(String id) {
        var homeworkDB = homeworkDao.findById(id).get();
        return objectMapper.readValue(homeworkDB.getJsonContent(), com.ztlsir.homework.homework.model.Homework.class);
    }
}
