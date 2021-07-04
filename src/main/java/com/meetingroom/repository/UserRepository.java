package com.meetingroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetingroom.models.UserModel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserRepository extends CrudRepository<UserModel, Long> {

}
