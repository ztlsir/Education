package com.ztlsir.homework.homework;

import com.ztlsir.homework.homework.command.CreateCommand;
import com.ztlsir.homework.homework.representation.HomeworkRepresentation;
import com.ztlsir.homework.homework.representation.HomeworkRepresentationService;
import com.ztlsir.shared.model.PagedResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@RestController
public class HomeworkController implements HomeworkClient {

    private final HomeworkApplicationService applicationService;
    private final HomeworkRepresentationService representationService;

    public HomeworkController(
            HomeworkApplicationService applicationService,
            HomeworkRepresentationService representationService) {
        this.applicationService = applicationService;
        this.representationService = representationService;
    }

    @Override
    public Map<String, String> create(@RequestBody @Valid CreateCommand command) {
        return of("id", applicationService.create(command));
    }

    @Override
    public HomeworkRepresentation byId(@PathVariable(name = "id") String id) {
        return representationService.byId(id);
    }

    @Override
    public PagedResource<HomeworkRepresentation> pagedHomeworks(
            @RequestParam(required = false, defaultValue = "1") int pageIndex,
            @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return representationService.pagedHomeworks(pageIndex,pageSize);
    }
}
