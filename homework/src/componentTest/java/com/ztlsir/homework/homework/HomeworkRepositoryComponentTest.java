package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.model.Homework;
import com.ztlsir.shared.value.ClassAndGrade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class HomeworkRepositoryComponentTest {
    @Autowired
    private HomeworkRepository homeworkRepository;

    @Test
    public void should_save_homework() {
        ClassAndGrade classAndGrade =new ClassAndGrade(1,2);
        Homework homework = Homework.create("test_id",classAndGrade,"test_teacherId","test_content");

        homeworkRepository.save(homework);

        Homework homeworkFromDB = homeworkRepository.byId(homework.getId());
        assertEquals(homework.getCreatedAt(), homeworkFromDB.getCreatedAt());
        assertEquals(homework.getClassAndGrade(), homeworkFromDB.getClassAndGrade());
        assertEquals(homework.getStatus(), homeworkFromDB.getStatus());
        assertEquals(homework.getTeacherId(), homeworkFromDB.getTeacherId());
        assertEquals(homework.getContent(), homeworkFromDB.getContent());
    }
}