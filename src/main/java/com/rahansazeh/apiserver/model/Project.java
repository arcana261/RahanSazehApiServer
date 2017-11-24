package com.rahansazeh.apiserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Project {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NotEmpty
    private String title;

    @DBRef(lazy = true)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProjectLine> lines;

    @DBRef
    @JsonIgnore
    private List<VehicleType> vehicleTypes;

    public Project(String title) {
        this.title = title;
    }

    public Project() { }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<ProjectLine> getLines() {
        if (lines == null) {
            lines = new ArrayList<>();
        }

        return lines;
    }

    public void addLine(ProjectLine line) {
        getLines().add(line);
    }

    public void removeLine(ProjectLine line) {
        getLines().remove(line);
    }

    public void removeAllLines() {
        getLines().clear();
    }

    public List<VehicleType> getVehicleTypes() {
        if (vehicleTypes == null) {
            vehicleTypes = new ArrayList<>();
        }

        return vehicleTypes;
    }

    public void addVehicleType(VehicleType vehicleType) {
        getVehicleTypes().add(vehicleType);
    }

    public void removeVehicleType(VehicleType vehicleType) {
        getVehicleTypes().remove(vehicleType);
    }

    public void removeAllVehicleTypes() {
        getVehicleTypes().clear();
    }
}
