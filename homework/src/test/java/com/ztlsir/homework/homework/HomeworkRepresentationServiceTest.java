package com.ztlsir.homework.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.ztlsir.homework.dao.HomeworkDao;
import com.ztlsir.homework.entity.Homework;
import com.ztlsir.homework.homework.Representation.model.HomeworkRepresentation;
import com.ztlsir.shared.model.PagedResource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.PropertyAccessor.ALL;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static java.time.ZoneId.of;
import static java.util.TimeZone.getTimeZone;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(
        classes = ObjectMapper.class)
@ExtendWith(SpringExtension.class)
public class HomeworkRepresentationServiceTest {
    @Mock
    private HomeworkRepository homeworkRepository;
    @Mock
    private HomeworkDao homeworkDao;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    private void init(){
        this.objectMapper.findAndRegisterModules()
                .configure(WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Test
    public void shoudl_get_paged_homeworks() {
        int pageIndex = 1;
        int pageSize = 10;
        List<Homework> homeworks = Lists.newArrayList(
                new Homework("test_id_one", "{\"id\":\"test_id_one\",\"classAndGrade\":{\"grade\":5,\"classes\":7},\"teacherId\":\"000002\",\"createdAt\":\"2020-04-27T02:02:06.612597Z\",\"content\":\"{\\\"description\\\":\\\"典章制度松if将阿迪力开始放假啊离开的时间疯狂拉升的减肥了\\\",\\\"imageId\\\":\\\"86bd9f2e-3cd8-4a5a-ab66-710de3fcfb0b\\\"}\",\"status\":\"EDIT\"}"),
                new Homework("test_id_two", "{\"id\":\"test_id_two\",\"classAndGrade\":{\"grade\":5,\"classes\":7},\"teacherId\":\"000002\",\"createdAt\":\"2020-04-27T02:02:06.612597Z\",\"content\":\"{\\\"description\\\":\\\"典章制度松if将阿迪力开始放假啊离开的时间疯狂拉升的减肥了\\\",\\\"imageId\\\":\\\"86bd9f2e-3cd8-4a5a-ab66-710de3fcfb0b\\\"}\",\"status\":\"EDIT\"}"));
        when(this.homeworkDao.findAll(Mockito.any(PageRequest.class)))
                .thenReturn(new PageImpl<>(homeworks));
        HomeworkRepresentationService homeworkRepresentationService = new HomeworkRepresentationService(this.homeworkRepository, this.homeworkDao, this.objectMapper);

        PagedResource<HomeworkRepresentation> pagedHomeworks =
                homeworkRepresentationService.pagedHomeworks(pageIndex, pageSize);

        assertEquals(homeworks.size(), pagedHomeworks.getResource().size());
    }

}
