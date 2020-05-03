package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.Representation.model.HomeworkRepresentation;
import com.ztlsir.homework.homework.command.CreateCommand;
import com.ztlsir.shared.model.PagedResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static com.google.common.collect.ImmutableMap.of;

@RestController
@RequestMapping(value = "/homeworks")
public class HomeworkController {

    private final HomeworkApplicationService applicationService;
    private final HomeworkRepresentationService representationService;

    public HomeworkController(
            HomeworkApplicationService applicationService,
            HomeworkRepresentationService representationService) {
        this.applicationService = applicationService;
        this.representationService = representationService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Map<String, String> create(@RequestBody @Valid CreateCommand command) {
        return of("id", applicationService.create(command));
    }

    @GetMapping("/{id}")
    public HomeworkRepresentation byId(@PathVariable(name = "id") String id) {
        return representationService.byId(id);
    }

    @GetMapping
    public PagedResource<HomeworkRepresentation> pagedHomeworks(
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return representationService.pagedHomeworks(pageIndex,pageSize);
    }
}
