package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PassengerRecord {
    @Id
    private String id;

    @Indexed(name = "passenger_client_id_index")
    private String clientId;

    @DBRef
    private User user;

    @DBRef
    private Project project;

    @DBRef
    private ProjectLine projectLine;

    private int year;
    private int month;
    private int day;

    private int startHour;
    private int startMinute;
    private int finishHour;
    private int finishMinute;

    private int passengerCount;
    private boolean hasSelectedHead;

    public PassengerRecord(String clientId, int year, int month, int day,
                           int startHour, int startMinute,
                           int finishHour, int finishMinute,
                           int passengerCount, boolean hasSelectedHead) {
        this.clientId = clientId;
        this.year = year;
        this.month = month;
        this.day = day;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.finishHour = finishHour;
        this.finishMinute = finishMinute;
        this.passengerCount = passengerCount;
        this.hasSelectedHead = hasSelectedHead;
    }

    public PassengerRecord() { }


    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void setProjectLine(ProjectLine projectLine) {
        this.projectLine = projectLine;
    }

    public String getClientId() {
        return clientId;
    }
}
