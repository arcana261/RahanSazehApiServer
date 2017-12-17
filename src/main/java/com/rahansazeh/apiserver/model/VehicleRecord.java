package com.rahansazeh.apiserver.model;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.rahansazeh.apiserver.model.serializer.ProjectIdSerializer;
//import com.rahansazeh.apiserver.model.serializer.ProjectLineIdSerializer;
//import com.rahansazeh.apiserver.model.serializer.UserIdSerializer;
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
//public class VehicleRecord {
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @Id
//    private String id;
//
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
//    @Transient
//    @JsonProperty(value = "licensePlate", access = JsonProperty.Access.WRITE_ONLY)
//    private String request_licensePlate;
//
//    @Transient
//    @JsonProperty(value = "vehicleType", access = JsonProperty.Access.WRITE_ONLY)
//    private String request_vehicleType;
//
//    @Indexed(name = "client_id_index")
//    private String clientId;
//
//    @DBRef
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonSerialize(using = UserIdSerializer.class)
//    private User user;
//
//    private boolean hasLoaded;
//    private boolean hasUnLoaded;
//
//    @DBRef
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonSerialize(using = ProjectIdSerializer.class)
//    private Project project;
//
//    @DBRef
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JsonSerialize(using = ProjectLineIdSerializer.class)
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
//    private boolean hasArrivalTime;
//
//    @Min(0)
//    @Max(59)
//    private int arrivalTimeHour;
//
//    @Min(0)
//    @Max(59)
//    private int arrivalTimeMinute;
//
//    @Min(0)
//    @Max(59)
//    private int arrivalTimeSecond;
//
//    private boolean hasDepartureTime;
//
//    @Min(0)
//    @Max(59)
//    private int departureTimeHour;
//
//    @Min(0)
//    @Max(59)
//    private int departureTimeMinute;
//
//    @Min(0)
//    @Max(59)
//    private int departureTimeSecond;
//
//    @Min(0)
//    @Max(100)
//    private int loadPassengerCount;
//
//    @Min(0)
//    @Max(100)
//    private int unloadPassengerCount;
//
//    private boolean hasSelectedHeadTerminal;
//
//    public VehicleRecord(String clientId, boolean hasLoaded, boolean hasUnLoaded,
//                         int year, int month, int day, boolean hasArrivalTime,
//                         int arrivalTimeHour, int arrivalTimeMinute, int arrivalTimeSecond,
//                         boolean hasDepartureTime, int departureTimeHour, int departureTimeMinute,
//                         int departureTimeSecond, int loadPassengerCount, int unloadPassengerCount,
//                         boolean hasSelectedHeadTerminal) {
//        this.clientId =clientId;
//        this.hasLoaded = hasLoaded;
//        this.hasUnLoaded = hasUnLoaded;
//        this.year = year;
//        this.month = month;
//        this.day = day;
//        this.hasArrivalTime = hasArrivalTime;
//        this.arrivalTimeHour = arrivalTimeHour;
//        this.arrivalTimeMinute = arrivalTimeMinute;
//        this.arrivalTimeSecond = arrivalTimeSecond;
//        this.hasDepartureTime = hasDepartureTime;
//        this.departureTimeHour = departureTimeHour;
//        this.departureTimeMinute = departureTimeMinute;
//        this.departureTimeSecond = departureTimeSecond;
//        this.loadPassengerCount = loadPassengerCount;
//        this.unloadPassengerCount = unloadPassengerCount;
//        this.hasSelectedHeadTerminal = hasSelectedHeadTerminal;
//    }
//
//    public VehicleRecord() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getClientId() {
//        return clientId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public boolean isHasLoaded() {
//        return hasLoaded;
//    }
//
//    public boolean isHasUnLoaded() {
//        return hasUnLoaded;
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
//    public boolean isHasArrivalTime() {
//        return hasArrivalTime;
//    }
//
//    public int getArrivalTimeHour() {
//        return arrivalTimeHour;
//    }
//
//    public int getArrivalTimeMinute() {
//        return arrivalTimeMinute;
//    }
//
//    public int getArrivalTimeSecond() {
//        return arrivalTimeSecond;
//    }
//
//    public boolean isHasDepartureTime() {
//        return hasDepartureTime;
//    }
//
//    public int getDepartureTimeHour() {
//        return departureTimeHour;
//    }
//
//    public int getDepartureTimeMinute() {
//        return departureTimeMinute;
//    }
//
//    public int getDepartureTimeSecond() {
//        return departureTimeSecond;
//    }
//
//    public int getLoadPassengerCount() {
//        return loadPassengerCount;
//    }
//
//    public int getUnloadPassengerCount() {
//        return unloadPassengerCount;
//    }
//
//    public boolean isHasSelectedHeadTerminal() {
//        return hasSelectedHeadTerminal;
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
//
//    public String getRequest_licensePlate() {
//        return request_licensePlate;
//    }
//
//    public String getRequest_vehicleType() {
//        return request_vehicleType;
//    }
//}
