package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.Project;
import com.rahansazeh.apiserver.model.ProjectLine;
import com.rahansazeh.apiserver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProjectListController {
    @Autowired
    private ProjectRepository repository;

    @RequestMapping("/project")
    public Response<List<Project>> getProjects() {
        return Response.success(repository.findAll());
    }
}
