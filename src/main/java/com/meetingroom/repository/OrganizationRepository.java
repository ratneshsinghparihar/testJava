package com.meetingroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetingroom.models.OrganizationModel;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "organization", path = "organization")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface OrganizationRepository extends CrudRepository<OrganizationModel, Long> {

}
