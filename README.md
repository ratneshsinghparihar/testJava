# testJava
Meeting app
 1. the organization have multiple users
 2. the organization have mulitple locations
 3. the location have mulitple rooms
 4. user can book event  for once (startDateTime, Duration ),
    user can book recurring meeting (startDateTime,Duration, endDateTimeofSeries)   
 5. user can check his booking history
 6. user can check rooms availables for a location for particular datetime
 
 *All JPA enities are immplemented
 **need to setup mysql and change connection string (locally)
 *** immplement following methods in Booking Service
  List<RoomModel> getAllAvaiableRoomsByLocation(Date startTime,int duration, Long locationId);
	boolean isRoomAvaiable(BookingParam param);
	long bookRoom(BookingParam param);
