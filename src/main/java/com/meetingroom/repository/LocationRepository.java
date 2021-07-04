package com.meetingroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetingroom.models.LocationModel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface LocationRepository extends CrudRepository<LocationModel, Long> {

}
