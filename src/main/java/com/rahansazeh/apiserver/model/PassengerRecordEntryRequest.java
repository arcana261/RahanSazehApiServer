package com.rahansazeh.apiserver.model;

public class PassengerRecordEntryRequest {
    private Long id;
    private String userName;
    private Long projectId;
    private Long projectLineId;

    private int year;
    private int month;
    private int day;

    private int startHour;
    private int startMinute;
    private int finishHour;
    private int finishMinute;

    private int passengerCount;
    private boolean hasSelectedHead;

    public PassengerRecordEntryRequest() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getProjectLineId() {
        return projectLineId;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getFinishHour() {
        return finishHour;
    }

    public int getFinishMinute() {
        return finishMinute;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public boolean isHasSelectedHead() {
        return hasSelectedHead;
    }
}
