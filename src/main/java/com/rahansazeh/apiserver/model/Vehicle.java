package com.rahansazeh.apiserver.model;

public class Vehicle {
    private Long id;
    private int licensePlateLeft;
    private char licensePlateType;
    private int licensePlateRight;
    private int licensePlateNationalCode;
    private Long vehicleTypeId;

    public Vehicle(Long id, int licensePlateLeft, char licensePlateType,
                          int licensePlateRight, int licensePlateNationalCode,
                          Long vehicleTypeId) {
        this.id = id;
        this.licensePlateLeft = licensePlateLeft;
        this.licensePlateType = licensePlateType;
        this.licensePlateRight = licensePlateRight;
        this.licensePlateNationalCode = licensePlateNationalCode;
        this.vehicleTypeId = vehicleTypeId;
    }

    public Long getId() {
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

    public Long getVehicleTypeId() {
        return vehicleTypeId;
    }
}
