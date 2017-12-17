package com.rahansazeh.apiserver.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.rahansazeh.apiserver.model.serializer.VehicleIdSerializer;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import java.util.Date;
//
//@Document
//public class VehicleChangeEvent {
//    public static class EVENT_TYPE {
//        public static final String ADD = "add";
//        public static final String REMOVE = "remove";
//        public static final String CHANGE = "change";
//    }
//
//    @Id
//    @JsonIgnore
//    private String id;
//
//    @Pattern(regexp = "^(add|remove|change)$")
//    private String eventType;
//
//    @NotEmpty
//    @Indexed(name = "change_event_project_index")
//    @JsonIgnore
//    private String projectId;
//
//    @NotEmpty
//    private String vehicleId;
//
//    @Indexed(name = "epoch_index")
//    private Long epoch;
//
//    @Transient
//    private Vehicle vehicle;
//
//    public VehicleChangeEvent(String eventType, Vehicle vehicle) {
//        this.eventType = eventType;
//        this.vehicleId = vehicle.getId();
//        this.setVehicle(vehicle);
//        this.epoch = (new Date()).getTime();
//        this.projectId = vehicle.getProject().getId();
//    }
//
//    public VehicleChangeEvent() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getEventType() {
//        return eventType;
//    }
//
//    public String getVehicleId() {
//        return vehicleId;
//    }
//
//    public Long getEpoch() {
//        return epoch;
//    }
//
//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
//
//    public String getProjectId() {
//        return projectId;
//    }
//}
