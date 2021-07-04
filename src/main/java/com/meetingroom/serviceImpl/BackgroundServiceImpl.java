package com.meetingroom.serviceImpl;

import com.meetingroom.models.BookingModel;
import com.meetingroom.repository.BookingRepository;
import com.meetingroom.repository.BookingTrailRepository;
import com.meetingroom.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BackgroundServiceImpl implements BackgroundService {
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private BookingTrailRepository trailRepo;

    @Override
    @Scheduled(fixedRate = 1000*60)
    public void checkAndUpdateStatus() {
       

    }
}
