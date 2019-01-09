package com.travelfactory.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.travelfactory.entities.FileNameEntity;

public interface FileNameRepository extends MongoRepository<FileNameEntity, String> {

	FileNameEntity findByName(String name);



}
