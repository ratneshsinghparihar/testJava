package com.meetingroom.service;

import java.util.Date;
import java.util.List;

import com.meetingroom.models.RoomModel;
import com.meetingroom.parameter.BookingParam;

public interface BookingService {
	List<RoomModel> getAllAvaiableRoomsByLocation(Date startTime,int duration, Long locationId);
	boolean isRoomAvaiable(BookingParam param);
	long bookRoom(BookingParam param);

}
