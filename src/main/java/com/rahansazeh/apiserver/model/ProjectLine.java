package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProjectLine {
    @Id
    private String id;

    private String title;
    private String head;
    private String tail;

    public ProjectLine(String title, String head, String tail) {
        this.title = title;
        this.head = head;
        this.tail = tail;
    }

    public ProjectLine() { }

    public String getId() {
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
