package com.meetingroom.parameter;

import com.meetingroom.models.RoomModel;
import com.meetingroom.models.UserModel;

import java.util.Date;

public class BookingParam {

    public BookingParam() {

    }

    private long roomId;

    private Date startTime;

    private int duration;

    private long userId;

    private String bookingTitle;

    private boolean isDaily;

    private boolean isWeakly;

    private Date endTimeSeries;

    private String frequencyDayOfWeek;

    private long locationId;

    public BookingParam(Date startTime, int duration, long locationId) {
        this.startTime = startTime;
        this.duration = duration;
        this.locationId = locationId;
    }

    public BookingParam(long roomId, Date startTime, int duration, long userId, String bookingTitle) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
        this.userId = userId;
        this.bookingTitle = bookingTitle;
    }

    public BookingParam(long roomId, Date startTime, int duration, long userId, String bookingTitle, boolean isDaily, boolean isWeakly, Date endTimeSeries, String frequencyDayOfWeek) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
        this.userId = userId;
        this.bookingTitle = bookingTitle;
        this.isDaily = isDaily;
        this.isWeakly = isWeakly;
        this.endTimeSeries = endTimeSeries;
        this.frequencyDayOfWeek = frequencyDayOfWeek;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }
    public boolean isDaily() {
        return isDaily;
    }

    public void setDaily(boolean daily) {
        isDaily = daily;
    }

    public boolean isWeakly() {
        return isWeakly;
    }

    public void setWeakly(boolean weakly) {
        isWeakly = weakly;
    }

    public Date getEndTimeSeries() {
        return endTimeSeries;
    }

    public void setEndTimeSeries(Date endTimeSeries) {
        this.endTimeSeries = endTimeSeries;
    }

    public String getFrequencyDayOfWeek() {
        return frequencyDayOfWeek;
    }

    public void setFrequencyDayOfWeek(String frequencyDayOfWeek) {
        this.frequencyDayOfWeek = frequencyDayOfWeek;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }
}