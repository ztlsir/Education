package com.ztlsir.homework.homework.model;

import com.ztlsir.shared.value.ClassAndGrade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HomeworkApplicationTests {

	@Test
	public void should_create_homework() {
		ClassAndGrade classAndGrade =new ClassAndGrade(1,2);

		Homework homework = Homework.create("test_id",classAndGrade,"test_teacherId","test_content");

		assertEquals(HomeworkStatus.EDIT, homework.getStatus());
	}
}
