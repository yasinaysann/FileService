package com.yasin.fileservice.repository;

import com.yasin.fileservice.entity.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File,Long> {
    File findById(String id);
    Boolean existsById(String id);
    void deleteById(String id);
}
