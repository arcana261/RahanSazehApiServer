package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VehicleType {
    @Id
    private String id;

    private String title;

    public VehicleType(String title) {
        this.title = title;
    }

    public VehicleType() { }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
