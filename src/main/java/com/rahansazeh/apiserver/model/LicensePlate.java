package com.rahansazeh.apiserver.model;

public class LicensePlate {
    private int licensePlateLeft;
    private int licensePlateRight;
    private int licensePlateNationalCode;
    private char licensePlateType;

    public LicensePlate(int licensePlateLeft, char licensePlateType, int licensePlateRight,
                        int licensePlateNationalCode) {
        this.licensePlateLeft = licensePlateLeft;
        this.licensePlateType = licensePlateType;
        this.licensePlateRight = licensePlateRight;
        this.licensePlateNationalCode = licensePlateNationalCode;
    }

    public int getLicensePlateLeft() {
        return licensePlateLeft;
    }

    public int getLicensePlateRight() {
        return licensePlateRight;
    }

    public int getLicensePlateNationalCode() {
        return licensePlateNationalCode;
    }

    public char getLicensePlateType() {
        return licensePlateType;
    }
}
