package com.meetingroom.controller;

import com.meetingroom.models.RoomModel;
import com.meetingroom.parameter.BookingParam;
import com.meetingroom.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping(path="availablerooms")
    public List<RoomModel> availableRooms(@RequestBody BookingParam param)
 {
        Date startTime = param.getStartTime();
        int duration = param.getDuration();
        long locationId = param.getLocationId();
        List<RoomModel> availableRooms = service.getAllAvaiableRoomsByLocation(startTime, duration, locationId);
        availableRooms.stream().forEach(x->{x.setLocation(null); x.setBookingRooms(null); });
        return  availableRooms;
    }
    @PostMapping(path="bookrooms")
    public long bookRoom(@RequestBody BookingParam param){
        long bookingId = service.bookRoom(param);
        return bookingId;
    }
}
