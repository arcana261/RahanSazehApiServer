package com.rahansazeh.apiserver.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String id;

    @Indexed(name = "national_code_index")
    private String nationalCode;

    public User(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public User() { }

    public String getId() {
        return id;
    }

    public String getNationalCode() {
        return nationalCode;
    }
}
