package com.ztlsir.homework.homework;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/homeworks")
public class HomeworkController {

    private final HomeworkApplicationService homeworkApplicationService;

    public HomeworkController(HomeworkApplicationService homeworkApplicationService) {
        this.homeworkApplicationService = homeworkApplicationService;
    }
}
