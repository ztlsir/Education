package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.command.CreateCommand;
import com.ztlsir.homework.homework.representation.HomeworkRepresentation;
import com.ztlsir.shared.model.PagedResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;

@FeignClient(value = "homework-service",contextId = "HomeworkClient")
@RequestMapping(value = "/homeworks")
public interface HomeworkClient {

    @PostMapping
    @ResponseStatus(CREATED)
    public Map<String, String> create(@RequestBody @Valid CreateCommand command);

    @GetMapping("/{id}")
    public HomeworkRepresentation byId(@PathVariable(name = "id") String id);

    @GetMapping
    public PagedResource<HomeworkRepresentation> pagedHomeworks(
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            @RequestParam(required = false, defaultValue = "10") int pageSize);
}