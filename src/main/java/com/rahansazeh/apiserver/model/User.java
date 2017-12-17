package com.rahansazeh.apiserver.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.validation.constraints.NotNull;
//
//@Document
//public class User {
//    @Id
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    private String id;
//
//    @Indexed(name = "national_code_index", unique = true)
//    @NotEmpty
//    private String nationalCode;
//
//    public User(String nationalCode) {
//        this.nationalCode = nationalCode;
//    }
//
//    public User() { }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getNationalCode() {
//        return nationalCode;
//    }
//}
