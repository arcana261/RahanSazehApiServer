package com.rahansazeh.apiserver.model;

public class ProjectLine {
    private Long id;
    private String title;
    private String head;
    private String tail;

    public ProjectLine(Long id, String title, String head, String tail) {
        this.id = id;
        this.title = title;
        this.head = head;
        this.tail = tail;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getHead() {
        return head;
    }

    public String getTail() {
        return tail;
    }
}
