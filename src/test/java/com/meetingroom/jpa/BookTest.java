package com.meetingroom.jpa;

import java.util.*;

import com.meetingroom.parameter.BookingParam;
import com.meetingroom.service.BackgroundService;
import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meetingroom.models.LocationModel;
import com.meetingroom.models.OrganizationModel;
import com.meetingroom.models.RoomModel;
import com.meetingroom.models.UserModel;
import com.meetingroom.repository.BookingRepository;
import com.meetingroom.repository.BookingTrailRepository;
import com.meetingroom.repository.LocationRepository;
import com.meetingroom.repository.OrganizationRepository;
import com.meetingroom.repository.RoomRepository;
import com.meetingroom.repository.UserRepository;
import com.meetingroom.service.BookingService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//@ExtendWith(SpringExtension.class)

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest {
    @Autowired
    private UserRepository userRepository;
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

    @Autowired
    private BookingService service;

    @Autowired
    private BackgroundService backgroundService;

    OrganizationModel cogni = null;
    UserModel bob = null;
    UserModel eve = null;
    UserModel alice = null;
    LocationModel floor1 = null;
    LocationModel floor2 = null;
    RoomModel room1 = null;
    RoomModel room2 = null;
    RoomModel room3 = null;
    RoomModel room4 = null;
    List<RoomModel> roomList1 = new ArrayList<RoomModel>();
    List<RoomModel> roomList2 = new ArrayList<RoomModel>();


    @Test
	@Rollback(false)
    @Order(1)
	public void Test1_Setup() throws Exception {
		System.out.println("befor1");
		cogni = new OrganizationModel("Cognizant");
		OrganizationModel cogniS = orgRepo.save(cogni);

		bob=new UserModel("bob");
		bob.setOrganization(cogni);
		bob = userRepository.save(bob);
		System.out.println("befor1");
		eve = new UserModel("eve");
		eve.setOrganization(cogni);
		eve = userRepository.save(eve);
		System.out.println("befor1");
		alice=new UserModel("alice");
		alice.setOrganization(cogni);
		alice= userRepository.save(alice);
		System.out.println("befor1");
		room1 = new RoomModel("Room1");
		room2 = new RoomModel("Room2");
		System.out.println("befor1");
		roomList1.add(room1);
		roomList1.add(room2);
		System.out.println("befor1");
		floor1 = new LocationModel("1st floor , 2nd phase hinjewadi");
		floor1.setOrganization(cogni);
		floor1.setRooms(roomList1);
		room1.setLocation(floor1);
		room2.setLocation(floor1);
		System.out.println("befor1");
		room3 = new RoomModel("Room3");
		room4 = new RoomModel("Room4");

		roomList2.add(room3);
		roomList2.add(room4);

		floor2 = new LocationModel("2st floor , 2nd phase hinjewadi");
		floor2.setOrganization(cogni);
		floor2.setRooms(roomList2);
		room3.setLocation(floor2);
		room4.setLocation(floor2);
		floor1 = locationRepo.save(floor1);
		floor2 = locationRepo.save(floor2);

		System.out.println("before2");

	}
//	
//	@Test
//	public void injectionTest() {
//		System.out.println("work");
//		
//	}

    private Date getMidnightDate() {
        Calendar calEnd = new GregorianCalendar();
        calEnd.setTime(new Date());
        //calEnd.set(Calendar.DAY_OF_YEAR, calEnd.get(Calendar.DAY_OF_YEAR)+1);
        calEnd.set(Calendar.HOUR_OF_DAY, 0);
        calEnd.set(Calendar.MINUTE, 0);
        calEnd.set(Calendar.SECOND, 0);
        calEnd.set(Calendar.MILLISECOND, 0);
        return calEnd.getTime();
    }
	@Test
    @Order(2)
	public void Test2_bobCheckBooking() {
		Date setDate = getMidnightDate();
		setDate = DateUtils.addDays(setDate, 1);

		setDate = DateUtils.addHours(setDate, 13);

		boolean check=service.getAllAvaiableRoomsByLocation( setDate, 60, 1l).size() == 2;
		assertEquals(true, check);
	}

    @Test
    @Order(3)
    public void Test3_bobDoBookingSameEvent() {
        Date setDate = getMidnightDate();
        setDate = DateUtils.addDays(setDate, 1);

        setDate = DateUtils.addHours(setDate, 13);
        BookingParam parma = new BookingParam(1, setDate, 60, 1, "test Booking");
        boolean check=service.bookRoom(parma )!= 0;
        assertEquals(true, check);

    }

    @Test
    @Order(4)
    public void t4_bobDoBookingSameEventAfter15Mins4() {
        Date setDate = getMidnightDate();
        setDate = DateUtils.addDays(setDate, 1);

        setDate = DateUtils.addHours(setDate, 13);
        setDate = DateUtils.addMinutes(setDate, 15);

        BookingParam parma = new BookingParam(1, setDate, 60, 1, "test Booking");

       boolean check = service.bookRoom(parma) != 0;
       assertEquals(false, check);
    }

    @Test
    @Order(5)
    public void t5_bobDoBookingSameEventStartBefore30minEndAfter30min5() {
        Date setDate = getMidnightDate();
        setDate = DateUtils.addDays(setDate, 1);

        setDate = DateUtils.addHours(setDate, 12);
        setDate = DateUtils.addMinutes(setDate, 30);
        BookingParam parma = new BookingParam(1, setDate, 60, 1, "test Booking");
        boolean check = service.bookRoom(parma) != 0;
        assertEquals(false, check);
    }

    @Test
    @Order(6)
    public void t6_bobDoBookingOtherRoomAtSameTime() {
        Date setDate = getMidnightDate();
        setDate = DateUtils.addDays(setDate, 1);

        setDate = DateUtils.addHours(setDate, 13);
        BookingParam parma = new BookingParam(2, setDate, 60, 1, "test Booking");
        boolean check = service.bookRoom(parma) != 0;
        assertEquals(true, check);
    }
    @Test
    @Order(7)
    public void eveSearchRoom2Floor() {
        Date setDate = getMidnightDate();
        setDate = DateUtils.addDays(setDate, 1);

        setDate = DateUtils.addHours(setDate, 13);
        setDate = DateUtils.addMinutes(setDate, 15);
        boolean check=service.getAllAvaiableRoomsByLocation(setDate, 30, 1l).size() == 0;
        assertEquals(true, check);
    }

//    @Test
//    @Order(8)
//    public void checkDateMethod(){
//        Date setDate = getMidnightDate();
//        Date setDate2 = getMidnightDate();
//        setDate = DateUtils.addDays(setDate, 1);
//
//        setDate = DateUtils.addHours(setDate, 13);
//        setDate = DateUtils.addMinutes(setDate, 15);
//        System.out.println("setDate"+ setDate);
//        setDate2 = DateUtils.addDays(setDate2, 2);
//
//        setDate2 = DateUtils.addHours(setDate2, 14);
//        setDate2 = DateUtils.addMinutes(setDate2, 30);
//        System.out.println("setDate2"+ setDate2);
//        System.out.println("Date result"+ service.changeDate(setDate, setDate2) );
//    }

    @Test
    @Order(8)
    public void bookAliceDailyFromNextWeek(){
        Date setDate = getMidnightDate();
        setDate = DateUtils.addWeeks(setDate, 1);

        setDate = DateUtils.addHours(setDate, 15);
        Date setEndDate = getMidnightDate();

        setEndDate =DateUtils.addMonths(setEndDate, 3);
        BookingParam parma = new BookingParam(1, setDate, 60, 2, "test Booking Alice Daily", true, false, setEndDate,null);
        boolean check = service.bookRoom(parma) != 0;
        assertEquals(true, check);


    }


    @Test
    @Order(9)
    public void booKBobOnceNextWeek3pm(){
        Date setDate = getMidnightDate();
        setDate = DateUtils.addWeeks(setDate, 2);

        setDate = DateUtils.addHours(setDate, 15);
        BookingParam parma = new BookingParam(1, setDate, 60, 1, "test Booking BoB Next to Week");
        boolean check = service.bookRoom(parma) != 0;
        assertEquals(false, check);
    }

    @Test
    @Order(10)
    public void bookEveWeeklyFromNextWeek(){
        Date setDate = getMidnightDate();
        setDate = DateUtils.addWeeks(setDate, 1);

        setDate = DateUtils.addHours(setDate, 17);
        Date setEndDate = getMidnightDate();

        setEndDate =DateUtils.addMonths(setDate, 3);
        BookingParam parma = new BookingParam(1, setDate, 60, 3, "test Booking Eve Daily", false, true, setEndDate,null);
        boolean check = service.bookRoom(parma) != 0;
        assertEquals(true, check);


    }

    @Test
    @Order(11)
    public void booKBobOnceNextWeek4pm(){
        Date setDate = getMidnightDate();
        setDate = DateUtils.addWeeks(setDate, 2);

        setDate = DateUtils.addHours(setDate, 17);


        BookingParam parma = new BookingParam(1, setDate, 60, 1, "test Booking BoB Next to Week");
        boolean check = service.bookRoom(parma) != 0;
        assertEquals(false, check);
    }

    @Test
    @Order(12)
    public void bookBobFor1Min(){
        backgroundService.checkAndUpdateStatus();
    }

}
