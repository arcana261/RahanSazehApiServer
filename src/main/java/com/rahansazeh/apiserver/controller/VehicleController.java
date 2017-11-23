package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.Vehicle;
import com.rahansazeh.apiserver.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping("/vehicle/{projectLineId}")
    public Response<List<Vehicle>> getVehicles(@PathVariable("projectLineId") String projectLineId) {
        return Response.success(vehicleRepository.findAll());
    }
}
