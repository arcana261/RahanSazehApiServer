package com.rahansazeh.apiserver.model;

public class PassengerRecordEntryRequest {
    private String id;
    private String userName;
    private String projectId;
    private String projectLineId;

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

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectLineId() {
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
