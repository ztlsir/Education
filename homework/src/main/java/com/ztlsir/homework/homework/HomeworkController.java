package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.command.CreateCommand;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static com.google.common.collect.ImmutableMap.of;

@RestController
@RequestMapping(value = "/homeworks")
public class HomeworkController {

    private final HomeworkApplicationService applicationService;

    public HomeworkController(HomeworkApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Map<String, String> create(@RequestBody @Valid CreateCommand command) {
        return of("id", applicationService.create(command));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
