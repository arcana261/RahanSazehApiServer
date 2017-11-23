package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VehicleRecord {
    @Id
    private String id;

    @Indexed(name = "client_id_index")
    private String clientId;

    @DBRef
    private User user;

    private boolean hasLoaded;
    private boolean hasUnLoaded;

    @DBRef
    private Project project;

    @DBRef
    private ProjectLine projectLine;

    private int year;
    private int month;
    private int day;

    private boolean hasArrivalTime;
    private int arrivalTimeHour;
    private int arrivalTimeMinute;
    private int arrivalTimeSecond;

    private boolean hasDepartureTime;
    private int departureTimeHour;
    private int departureTimeMinute;
    private int departureTimeSecond;

    private int loadPassengerCount;
    private int unloadPassengerCount;

    private boolean hasSelectedHeadTerminal;

    public VehicleRecord(String clientId, boolean hasLoaded, boolean hasUnLoaded,
                         int year, int month, int day, boolean hasArrivalTime,
                         int arrivalTimeHour, int arrivalTimeMinute, int arrivalTimeSecond,
                         boolean hasDepartureTime, int departureTimeHour, int departureTimeMinute,
                         int departureTimeSecond, int loadPassengerCount, int unloadPassengerCount,
                         boolean hasSelectedHeadTerminal) {
        this.clientId = clientId;
        this.hasLoaded = hasLoaded;
        this.hasUnLoaded = hasUnLoaded;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hasArrivalTime = hasArrivalTime;
        this.arrivalTimeHour = arrivalTimeHour;
        this.arrivalTimeMinute = arrivalTimeMinute;
        this.arrivalTimeSecond = arrivalTimeSecond;
        this.hasDepartureTime = hasDepartureTime;
        this.departureTimeHour = departureTimeHour;
        this.departureTimeMinute = departureTimeMinute;
        this.departureTimeSecond = departureTimeSecond;
        this.loadPassengerCount = loadPassengerCount;
        this.unloadPassengerCount = unloadPassengerCount;
        this.hasSelectedHeadTerminal = hasSelectedHeadTerminal;
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public User getUser() {
        return user;
    }

    public boolean isHasLoaded() {
        return hasLoaded;
    }

    public boolean isHasUnLoaded() {
        return hasUnLoaded;
    }

    public Project getProject() {
        return project;
    }

    public ProjectLine getProjectLine() {
        return projectLine;
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

    public int getDepartureTimeMinute() {
        return departureTimeMinute;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setProjectLine(ProjectLine projectLine) {
        this.projectLine = projectLine;
    }
}
