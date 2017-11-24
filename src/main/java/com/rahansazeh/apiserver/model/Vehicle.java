package com.rahansazeh.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rahansazeh.apiserver.model.serializer.ProjectIdSerializer;
import com.rahansazeh.apiserver.model.serializer.ProjectLineIdSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Document
public class Vehicle {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @Transient
    @JsonProperty(value = "vehicleTypeId", access = JsonProperty.Access.WRITE_ONLY)
    private String request_vehicleTypeId;

    @Min(0)
    @Max(99)
    @Indexed(name = "license_plate_left_index")
    private int licensePlateLeft;

    private char licensePlateType;

    @Min(0)
    @Max(999)
    @Indexed(name = "license_plate_right_index")
    private int licensePlateRight;

    @Min(0)
    @Max(99)
    private int licensePlateNationalCode;

    @DBRef
    private VehicleType vehicleType;

    @DBRef
    @Indexed(name = "project_index")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonSerialize(using = ProjectIdSerializer.class)
    private Project project;

    public Vehicle(int licensePlateLeft, char licensePlateType,
                   int licensePlateRight, int licensePlateNationalCode) {
        this.licensePlateLeft = licensePlateLeft;
        this.licensePlateType = licensePlateType;
        this.licensePlateRight = licensePlateRight;
        this.licensePlateNationalCode = licensePlateNationalCode;
    }

    public Vehicle() { }

    public String getId() {
        return id;
    }

    public int getLicensePlateLeft() {
        return licensePlateLeft;
    }

    public char getLicensePlateType() {
        return licensePlateType;
    }

    public int getLicensePlateRight() {
        return licensePlateRight;
    }

    public int getLicensePlateNationalCode() {
        return licensePlateNationalCode;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRequest_vehicleTypeId() {
        return request_vehicleTypeId;
    }
}
