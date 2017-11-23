package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Project {
    @Id
    private String id;

    private String title;

    @DBRef
    private List<ProjectLine> lines;

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
}
