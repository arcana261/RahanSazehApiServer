package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.Project;
import com.rahansazeh.apiserver.model.ProjectLine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProjectListController {
    @RequestMapping("/project")
    public Response<List<Project>> getProjects() {
        ProjectLine line = new ProjectLine(
                1l, "293", "میدان فاطمی", "پایانه سازمان آب");

        Project project = new Project(
                1l,
                "ساماندهی سامانه تاکسی‌رانی تهران",
                Collections.singletonList(line));

        return Response.success(Collections.singletonList(project));
    }
}
