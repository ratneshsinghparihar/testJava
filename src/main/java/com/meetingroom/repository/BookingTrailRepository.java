package com.meetingroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetingroom.models.BookingTrailModel;

public interface BookingTrailRepository extends CrudRepository<BookingTrailModel, Long> {

}
