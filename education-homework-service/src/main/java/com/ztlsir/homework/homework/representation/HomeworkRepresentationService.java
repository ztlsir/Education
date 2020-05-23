package com.ztlsir.homework.homework.representation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztlsir.homework.homework.repository.HomeworkDao;
import com.ztlsir.homework.homework.repository.HomeworkRepository;
import com.ztlsir.shared.model.PagedResource;
import lombok.SneakyThrows;
import lombok.var;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class HomeworkRepresentationService {
    private final HomeworkRepository homeworkRepository;
    private final HomeworkDao homeworkDao;
    private final ObjectMapper objectMapper;

    public HomeworkRepresentationService(
            HomeworkRepository homeworkRepository,
            HomeworkDao homeworkDao,
            ObjectMapper objectMapper) {
        this.homeworkRepository = homeworkRepository;
        this.homeworkDao = homeworkDao;
        this.objectMapper = objectMapper;
    }

    public HomeworkRepresentation byId(String id) {
        var homework = homeworkRepository.byId(id);
        return homework.toRepresentation();
    }

    public PagedResource<HomeworkRepresentation> pagedHomeworks(int pageIndex, int pageSize) {
        var pagedHomeworks = homeworkDao.findAll(PageRequest.of(pageIndex-1, pageSize));

        return PagedResource.of(
                pagedHomeworks.getTotalElements(),
                pageIndex,
                pagedHomeworks
                        .get()
                        .map(homeworkDB -> readValue(homeworkDB.getJsonContent(), HomeworkRepresentation.class))
                        .collect(Collectors.toList()));
    }

    @SneakyThrows
    private <T> T readValue(String content, Class<T> valueType) {
        return objectMapper.readValue(content, valueType);
    }
}
