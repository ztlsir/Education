package com.ztlsir.homework.file;

import com.ztlsir.homework.file.model.File;
import com.ztlsir.shared.model.BaseRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class FileRepository extends BaseRepository<File> {
    private final MongoTemplate mongoTemplate;

    public FileRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    protected void doSave(File file) {
        mongoTemplate.save(file);
    }

    public File GetById(String id) {
        return mongoTemplate.findById(id, File.class);
    }
}
