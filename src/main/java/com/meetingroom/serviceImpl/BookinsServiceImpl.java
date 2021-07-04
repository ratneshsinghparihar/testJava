package com.meetingroom.serviceImpl;

import java.util.*;
import java.util.stream.Collectors;

import com.meetingroom.models.*;
import com.meetingroom.parameter.BookingParam;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetingroom.repository.BookingRepository;
import com.meetingroom.repository.BookingTrailRepository;
import com.meetingroom.repository.LocationRepository;
import com.meetingroom.repository.OrganizationRepository;
import com.meetingroom.repository.RoomRepository;
import com.meetingroom.repository.UserRepository;
import com.meetingroom.service.BookingService;

@Service
public class BookinsServiceImpl implements BookingService {
	@Autowired 
	private UserRepository userRepo;
	@Autowired 
	private BookingRepository bookingRepo;
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private LocationRepository locationRepo;
	
	@Autowired
	private BookingTrailRepository trailRepo;

	
	

}
