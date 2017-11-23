package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.VehicleType;
import com.rahansazeh.apiserver.repository.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleTypeController {
    @Autowired
    private VehicleTypeRepository repository;

    @RequestMapping("/vehicleType/{projectLineId}")
    public Response<List<VehicleType>> getVehicleTypes(@PathVariable("projectLineId") String projectLineId) {
        return Response.success(repository.findAll());
    }
}
