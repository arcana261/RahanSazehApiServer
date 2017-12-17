package com.rahansazeh.apiserver.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.rahansazeh.apiserver.model.serializer.ProjectIdSerializer;
//import com.rahansazeh.apiserver.model.serializer.ProjectLineIdSerializer;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
//
//@Document
//public class PassengerRecord {
//    @Transient
//    @JsonProperty(value = "userName", access = JsonProperty.Access.WRITE_ONLY)
//    private String request_userName;
//
//    @Transient
//    @JsonProperty(value = "projectId", access = JsonProperty.Access.WRITE_ONLY)
//    private String request_projectId;
//
//    @Transient
//    @JsonProperty(value = "projectLineId", access = JsonProperty.Access.WRITE_ONLY)
//    private String request_projectLineId;
//
//    @Id
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private String id;
//
//    @Indexed(name = "passenger_client_id_index")
//    private String clientId;
//
//    @DBRef
//    private User user;
//
//    @DBRef
//    @JsonSerialize(using = ProjectIdSerializer.class)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private Project project;
//
//    @DBRef
//    @JsonSerialize(using = ProjectLineIdSerializer.class)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private ProjectLine projectLine;
//
//    @Min(1390)
//    @Max(1450)
//    private int year;
//
//    @Min(1)
//    @Max(12)
//    private int month;
//
//    @Min(1)
//    @Max(31)
//    private int day;
//
//    @Min(0)
//    @Max(23)
//    private int startHour;
//
//    @Min(0)
//    @Max(59)
//    private int startMinute;
//
//    @Min(0)
//    @Max(23)
//    private int finishHour;
//
//    @Min(0)
//    @Max(59)
//    private int finishMinute;
//
//    @Min(0)
//    @Max(1000)
//    private int passengerCount;
//
//    private boolean hasSelectedHead;
//
//    public PassengerRecord(String clientId, int year, int month, int day,
//                           int startHour, int startMinute,
//                           int finishHour, int finishMinute,
//                           int passengerCount, boolean hasSelectedHead) {
//        this.clientId = clientId;
//        this.year = year;
//        this.month = month;
//        this.day = day;
//        this.startHour = startHour;
//        this.startMinute = startMinute;
//        this.finishHour = finishHour;
//        this.finishMinute = finishMinute;
//        this.passengerCount = passengerCount;
//        this.hasSelectedHead = hasSelectedHead;
//    }
//
//    public PassengerRecord() { }
//
//    public String getId() {
//        return id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public Project getProject() {
//        return project;
//    }
//
//    public ProjectLine getProjectLine() {
//        return projectLine;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public int getMonth() {
//        return month;
//    }
//
//    public int getDay() {
//        return day;
//    }
//
//    public int getStartHour() {
//        return startHour;
//    }
//
//    public int getStartMinute() {
//        return startMinute;
//    }
//
//    public int getFinishHour() {
//        return finishHour;
//    }
//
//    public int getFinishMinute() {
//        return finishMinute;
//    }
//
//    public int getPassengerCount() {
//        return passengerCount;
//    }
//
//    public boolean isHasSelectedHead() {
//        return hasSelectedHead;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    public void setProjectLine(ProjectLine projectLine) {
//        this.projectLine = projectLine;
//    }
//
//    public String getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(String clientId) {
//        this.clientId = clientId;
//    }
//
//    public String getRequest_userName() {
//        return request_userName;
//    }
//
//    public String getRequest_projectId() {
//        return request_projectId;
//    }
//
//    public String getRequest_projectLineId() {
//        return request_projectLineId;
//    }
//}
