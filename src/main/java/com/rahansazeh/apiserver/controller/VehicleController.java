package com.rahansazeh.apiserver.controller;

//import com.rahansazeh.apiserver.model.*;
//import com.rahansazeh.apiserver.repository.ProjectRepository;
//import com.rahansazeh.apiserver.repository.VehicleChangeRepository;
//import com.rahansazeh.apiserver.repository.VehicleRepository;
//import com.rahansazeh.apiserver.repository.VehicleTypeRepository;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//public class VehicleController {
//    @Autowired
//    private VehicleRepository vehicleRepository;
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    @Autowired
//    private VehicleTypeRepository vehicleTypeRepository;
//
//    @Autowired
//    private VehicleChangeRepository vehicleChangeRepository;
//
//    @GetMapping("/vehicle/{projectId}")
//    public Response<RangeWrapper<List<Vehicle>>> getVehicles(
//            @PathVariable("projectId") String projectId,
//            @RequestParam("page") Integer page,
//            @RequestParam("pageSize") Integer pageSize) {
//        long records = vehicleRepository.countByProject(new ObjectId(projectId));
//        pageSize = Math.min(pageSize, 50);
//
//        return Response.success(new RangeWrapper<>(
//                records, records, vehicleRepository.findByProject(
//                new ObjectId(projectId), new PageRequest(page, pageSize))));
//    }
//
//    @GetMapping("/vehicleChange/{projectId}")
//    public Response<RangeWrapper<List<VehicleChangeEvent>>> getVehicleChanges(
//            @PathVariable String projectId,
//            @RequestParam Long epoch,
//            @RequestParam Integer page,
//            @RequestParam Integer pageSize) {
//
//        pageSize = Math.min(pageSize, 50);
//
//        Page<VehicleChangeEvent> result = vehicleChangeRepository.getByProjectIdAndEpoch(projectId, epoch,
//                new PageRequest(page, pageSize, Sort.Direction.ASC, "epoch"));
//
//        result.getContent().forEach(change -> {
//            Vehicle vehicle = vehicleRepository.findOne(change.getVehicleId());
//
//            if (vehicle != null && vehicle.getVehicleType() == null) {
//                vehicle = null;
//            }
//
//            change.setVehicle(vehicle);
//        });
//
//        return Response.success(new RangeWrapper<>(result.getTotalElements(), result.getTotalElements(),
//                result.getContent()));
//    }
//
//    @PostMapping("/vehicle/{projectId}")
//    public Response<IdentifierResponse> createVehicle(
//            @PathVariable String projectId,
//            @RequestBody @Valid Vehicle request) {
//        Project project = projectRepository.findOne(projectId);
//        if (project == null) {
//            return Response.error(new Exception("project not found"));
//        }
//
//        VehicleType vehicleType = vehicleTypeRepository.findOne(request.getRequest_vehicleTypeId());
//        if (vehicleType == null) {
//            return Response.error(new Exception("vehicle type not found"));
//        }
//
//        Vehicle vehicle = vehicleRepository.save(new Vehicle(request.getLicensePlateLeft(),
//                request.getLicensePlateType(),
//                request.getLicensePlateRight(),
//                request.getLicensePlateNationalCode()));
//
//        vehicle.setVehicleType(vehicleType);
//        vehicle.setProject(project);
//
//        vehicleRepository.save(vehicle);
//
//        vehicleChangeRepository.save(new VehicleChangeEvent(VehicleChangeEvent.EVENT_TYPE.ADD, vehicle));
//
//        return Response.success(new IdentifierResponse(vehicle.getId()));
//    }
//
//    @DeleteMapping("/vehicle/{projectId}")
//    public Response<BooleanResponse> deleteAllVehicles(@PathVariable String projectId) {
//        List<Vehicle> vehicles = vehicleRepository.findByProject(new ObjectId(projectId));
//
//        for (Vehicle vehicle : vehicles) {
//            vehicleRepository.delete(vehicle);
//            vehicleChangeRepository.save(new VehicleChangeEvent(VehicleChangeEvent.EVENT_TYPE.REMOVE, vehicle));
//        }
//
//        return Response.success(new BooleanResponse(true));
//    }
//}
