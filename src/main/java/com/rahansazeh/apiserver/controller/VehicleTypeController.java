package com.rahansazeh.apiserver.controller;
//
//import com.rahansazeh.apiserver.model.*;
//import com.rahansazeh.apiserver.repository.ProjectLineRepository;
//import com.rahansazeh.apiserver.repository.ProjectRepository;
//import com.rahansazeh.apiserver.repository.VehicleTypeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//public class VehicleTypeController {
//    @Autowired
//    private VehicleTypeRepository vehicleTypeRepository;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @GetMapping("/vehicleType/{projectId}")
//    public ResponseWrapper<List<VehicleType>> getVehicleTypes(@PathVariable("projectId") String projectId) {
//        Project project = projectRepository.findOne(projectId);
//        if (project == null) {
//            return ResponseWrapper.error(new Exception("project not found"));
//        }
//
//        return ResponseWrapper.success(project.getVehicleTypes());
//    }
//
//    @PostMapping("/vehicleType/{projectId}")
//    public ResponseWrapper<IdentifierResponse> createVehicleType(
//            @PathVariable String projectId,
//            @RequestBody @Valid VehicleType request) {
//        Project project = projectRepository.findOne(projectId);
//        if (project == null) {
//            return ResponseWrapper.error(new Exception("project not found"));
//        }
//
//        VehicleType vehicleType = vehicleTypeRepository.save(new VehicleType(request.getTitle()));
//        project.addVehicleType(vehicleType);
//        projectRepository.save(project);
//
//        return ResponseWrapper.success(new IdentifierResponse(vehicleType.getId()));
//    }
//
//    @GetMapping("/vehicleType/{projectId}/{vehicleTypeId}")
//    public ResponseWrapper<VehicleType> getVehicleType(
//            @PathVariable("projectId") String projectId,
//            @PathVariable String vehicleTypeId) {
//        Project project = projectRepository.findOne(projectId);
//        if (project == null) {
//            return ResponseWrapper.error(new Exception("project not found"));
//        }
//
//        VehicleType vehicleType =  vehicleTypeRepository.findOne(vehicleTypeId);
//        if (vehicleType == null) {
//            return ResponseWrapper.error(new Exception("vehicletype not found"));
//        }
//
//        return ResponseWrapper.success(vehicleType);
//    }
//
//    @DeleteMapping("/vehicleType/{projectId}/{vehicleTypeId}")
//    public ResponseWrapper<BooleanResponse> removeVehicleType(
//            @PathVariable("projectId") String projectId,
//            @PathVariable String vehicleTypeId) {
//        Project project = projectRepository.findOne(projectId);
//        if (project == null) {
//            return ResponseWrapper.error(new Exception("project not found"));
//        }
//
//        VehicleType vehicleType =  vehicleTypeRepository.findOne(vehicleTypeId);
//        if (vehicleType == null) {
//            return ResponseWrapper.error(new Exception("vehicletype not found"));
//        }
//
//        project.removeVehicleType(vehicleType);
//        projectRepository.save(project);
//
//        vehicleTypeRepository.delete(vehicleType);
//
//        return ResponseWrapper.success(new BooleanResponse(true));
//    }
//}
