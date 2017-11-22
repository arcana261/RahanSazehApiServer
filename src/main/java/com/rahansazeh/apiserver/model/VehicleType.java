package com.rahansazeh.apiserver.model;

public class VehicleType {
    private Long id;
    private String title;

    public VehicleType(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
