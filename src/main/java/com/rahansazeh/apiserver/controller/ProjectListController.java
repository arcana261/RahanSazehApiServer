package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.controller.error.NotFoundException;
import com.rahansazeh.apiserver.model.*;
import com.rahansazeh.apiserver.repository.ProjectLineRepository;
import com.rahansazeh.apiserver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class ProjectListController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectLineRepository lineRepository;

    @RequestMapping("/project")
    public Response<List<Project>> getProjects() {
        return Response.success(projectRepository.findAll());
    }

    @DeleteMapping("/project")
    public Response<BooleanResponse> deleteAllProjects() {
        projectRepository.deleteAll();
        lineRepository.deleteAll();
        return Response.success(new BooleanResponse(true));
    }

    @GetMapping("/project/{projectId}")
    public Response<Project> getProject(@PathVariable String projectId) throws Exception {
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }
        return Response.success(project);
    }

    @DeleteMapping("/project/{projectId}")
    public Response<BooleanResponse> deleteProject(@PathVariable String projectId) throws Exception {
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }

        projectRepository.delete(projectId);
        lineRepository.delete(project.getLines());

        return Response.success(new BooleanResponse(true));
    }

    @PostMapping("/project")
    public Response<IdentifierResponse> createProject(@Valid @RequestBody Project request) {
        Project project = projectRepository.save(new Project(request.getTitle()));
        return Response.success(new IdentifierResponse(project.getId()));
    }

    @GetMapping("/project/{projectId}/line")
    public Response<List<ProjectLine>> getProjectLines(@PathVariable String projectId) throws Exception {
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }

        return Response.success(project.getLines());
    }

    @PostMapping("/project/{projectId}/line")
    public Response<IdentifierResponse> addProjectLine(@PathVariable String projectId,
                                                       @Valid @RequestBody ProjectLine request) throws Exception {
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }

        ProjectLine line = lineRepository.save(new ProjectLine(
                request.getTitle(), request.getHead(), request.getTail()));

        project.addLine(line);
        projectRepository.save(project);

        return Response.success(new IdentifierResponse(line.getId()));
    }

    @DeleteMapping("/project/{projectId}/line")
    public Response<BooleanResponse> deleteAllProjectLines(@PathVariable String projectId) throws Exception {
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }

        ProjectLine[] lines = project.getLines().toArray(new ProjectLine[0]);

        project.removeAllLines();
        projectRepository.save(project);
        lineRepository.delete(Arrays.asList(lines));

        return Response.success(new BooleanResponse(true));
    }

    @GetMapping("/project/{projectId}/line/{lineId}")
    public Response<ProjectLine> getProjectLine(@PathVariable String projectId, @PathVariable String lineId) throws Exception {
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }

         ProjectLine line = project.getLines().stream()
                .filter(x -> lineId.equals(x.getId()))
                .findFirst().orElse(null);

        if (line == null) {
            return Response.error(new Exception("line not found"));
        }

        return Response.success(line);
    }

    @DeleteMapping("/project/{projectId}/line/{lineId}")
    public Response<BooleanResponse> deleteProjectLine(@PathVariable String projectId, @PathVariable String lineId) throws Exception{
        Project project = projectRepository.findOne(projectId);
        if (project == null) {
            throw new NotFoundException("project not found");
        }

         ProjectLine line = project.getLines().stream()
                .filter(x -> lineId.equals(x.getId()))
                .findFirst().orElse(null);

        if (line == null) {
            return Response.error(new Exception("line not found"));
        }

        project.removeLine(line);
        projectRepository.save(project);

        lineRepository.delete(line);

        return Response.success(new BooleanResponse(true));
    }
}
