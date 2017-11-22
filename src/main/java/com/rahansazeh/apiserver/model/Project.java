package com.rahansazeh.apiserver.model;

import java.util.List;

public class Project {
    private Long id;
    private String title;
    private List<ProjectLine> lines;

    public Project(Long id, String title, List<ProjectLine> lines) {
        this.id = id;
        this.title = title;
        this.lines = lines;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<ProjectLine> getLines() {
        return lines;
    }
}
