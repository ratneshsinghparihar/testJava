package com.meetingroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetingroom.models.BookingModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@RepositoryRestResource(collectionResourceRel = "booking", path = "booking")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface BookingRepository extends PagingAndSortingRepository<BookingModel, Long> {
    List<BookingModel> findByStatus(String status);
}
