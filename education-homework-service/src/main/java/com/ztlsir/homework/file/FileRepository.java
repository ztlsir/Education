package com.ztlsir.homework.file;

import com.ztlsir.homework.common.utils.mongo.template.MongoTemplateFactory;
import com.ztlsir.homework.file.model.File;
import com.ztlsir.shared.model.BaseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class FileRepository extends BaseRepository<File> {
    private static final String FILE_COLLECTION_NAME = "files";

    private final MongoTemplate mongoTemplate;

    public FileRepository(@Qualifier(MongoTemplateFactory.FILE_DATABASE_INJECT_NAME) MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    protected void doSave(File file) {
        mongoTemplate.save(file, FileRepository.FILE_COLLECTION_NAME);
    }

    public File GetById(String id) {
        return mongoTemplate.findById(id, File.class, FileRepository.FILE_COLLECTION_NAME);
    }
}
