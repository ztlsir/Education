package com.ztlsir.homework.homework;

import com.ztlsir.homework.BaseApiTest;
import com.ztlsir.homework.homework.command.CreateCommand;
import com.ztlsir.homework.homework.model.Homework;
import com.ztlsir.homework.homework.model.HomeworkStatus;
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
public class HomeworkControllerTest extends BaseApiTest {
    @Autowired
    private HomeworkRepository homeworkRepository;

    @Test
    public void should_save_homework() {
        ClassAndGrade classAndGrade = new ClassAndGrade(1, 2);
        CreateCommand commad = new CreateCommand(classAndGrade, "test_teacherId", "test_content");

        String id = given()
                .contentType("application/json")
                .body(new CreateCommand(classAndGrade, "test_teacherId", "test_content"))
                .when()
                .post("/homeworks")
                .then().statusCode(201)
                .extract().body().jsonPath().getString("id");

        Homework homeworkFromDB = homeworkRepository.byId(id);
        assertEquals(commad.getClassAndGrade(), homeworkFromDB.getClassAndGrade());
        assertEquals(HomeworkStatus.EDIT, homeworkFromDB.getStatus());
        assertEquals(commad.getTeacherId(), homeworkFromDB.getTeacherId());
        assertEquals(commad.getContent(), homeworkFromDB.getContent());
    }
}