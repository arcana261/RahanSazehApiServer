package com.rahansazeh.apiserver.model;

public class VehicleRecordEntryRequest {
    private String id;
    private String userName;
    private boolean hasLoaded;
    private boolean hasUnLoaded;
    private String projectId;
    private String projectLineId;

    private int year;
    private int month;
    private int day;

    private boolean hasArrivalTime;
    private int arrivalTimeHour;
    private int arrivalTimeMinute;
    private int arrivalTimeSecond;

    private boolean hasDepartureTime;
    private int departureTimeHour;
    private int departuerTimeMinute;
    private int departureTimeSecond;

    private int loadPassengerCount;
    private int unloadPassengerCount;

    private boolean hasSelectedHeadTerminal;

    public VehicleRecordEntryRequest() {
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isHasLoaded() {
        return hasLoaded;
    }

    public boolean isHasUnLoaded() {
        return hasUnLoaded;
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

    public boolean isHasArrivalTime() {
        return hasArrivalTime;
    }

    public int getArrivalTimeHour() {
        return arrivalTimeHour;
    }

    public int getArrivalTimeMinute() {
        return arrivalTimeMinute;
    }

    public int getArrivalTimeSecond() {
        return arrivalTimeSecond;
    }

    public boolean isHasDepartureTime() {
        return hasDepartureTime;
    }

    public int getDepartureTimeHour() {
        return departureTimeHour;
    }

    public int getDepartuerTimeMinute() {
        return departuerTimeMinute;
    }

    public int getDepartureTimeSecond() {
        return departureTimeSecond;
    }

    public int getLoadPassengerCount() {
        return loadPassengerCount;
    }

    public int getUnloadPassengerCount() {
        return unloadPassengerCount;
    }

    public boolean isHasSelectedHeadTerminal() {
        return hasSelectedHeadTerminal;
    }
}
