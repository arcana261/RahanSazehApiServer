package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {
    @Id
    private String id;

    private int licensePlateLeft;
    private char licensePlateType;
    private int licensePlateRight;
    private int licensePlateNationalCode;

    @DBRef
    private VehicleType vehicleType;

    public Vehicle(int licensePlateLeft, char licensePlateType,
                   int licensePlateRight, int licensePlateNationalCode) {
        this.licensePlateLeft = licensePlateLeft;
        this.licensePlateType = licensePlateType;
        this.licensePlateRight = licensePlateRight;
        this.licensePlateNationalCode = licensePlateNationalCode;
    }

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
}
