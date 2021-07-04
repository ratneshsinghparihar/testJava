package com.meetingroom.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang.time.DateUtils;

import com.meetingroom.entity.AuditedEntity;

@Entity(name = "Booking")
public class BookingModel extends AuditedEntity implements Cloneable {

    public Object clone()  {
        Object mm=null;
        try {
            mm= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  mm;
    }

    public BookingModel(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public BookingModel() {
        // TODO Auto-generated constructor stub
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "booking")
    List<BookingTrailModel> bookingTrailModelList;

    public List<BookingTrailModel> getBookingTrailModelList() {
        return bookingTrailModelList;
    }

    public void setBookingTrailModelList(List<BookingTrailModel> bookingTrailModelList) {
        this.bookingTrailModelList = bookingTrailModelList;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private UserModel user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomId")
    private RoomModel room;

    @Column
    private String status;

    @Column
    private Date bookingTime;

    @Column
    private boolean isDaily;

    @Column
    private boolean isWeakly;

    @Column
    private Date endTimeSeries;

    @Column
    private String frequencyDayOfWeek;

    @Column
    private Date startTime;

    @Column
    private int durationInMinutes;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isDaily() {
        return isDaily;
    }

    public void setDaily(boolean isDaily) {
        this.isDaily = isDaily;
    }

    public boolean isWeakly() {
        return isWeakly;
    }

    public void setWeakly(boolean isWeakly) {
        this.isWeakly = isWeakly;
    }

    public String getFrequencyDayOfWeek() {
        return frequencyDayOfWeek;
    }

    public void setFrequencyDayOfWeek(String frequencyDayOfWeek) {
        this.frequencyDayOfWeek = frequencyDayOfWeek;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Date getEndTime() {
        return DateUtils.addMinutes(this.startTime, this.durationInMinutes);
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEndTimeSeries() {
        return endTimeSeries;
    }

    public void setEndTimeSeries(Date endTimeSeries) {
        this.endTimeSeries = endTimeSeries;
    }

    public boolean isCompeleted(){
        Date currentDate = new Date();
        if(this.endTimeSeries == null){
            if(getEndTime().equals(currentDate) || getEndTime().before(currentDate)){
                return true;
            }
            return false;
        }
        if(this.endTimeSeries.equals(currentDate) || this.endTimeSeries.before(currentDate)){
            return true;
        }
        return false;
    }
}
