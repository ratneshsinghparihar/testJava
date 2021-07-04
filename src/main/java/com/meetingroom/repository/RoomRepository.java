package com.meetingroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetingroom.models.RoomModel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "room", path = "room")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface RoomRepository extends CrudRepository<RoomModel, Long> {

}
