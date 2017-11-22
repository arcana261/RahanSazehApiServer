package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleController {
    @RequestMapping("/vehicle/{projectLineId}")
    public Response<List<Vehicle>> getVehicles(@PathVariable("projectLineId") Long projectLineId) {
        ArrayList<Vehicle> result = new ArrayList<>();

        result.add(new Vehicle(1l,
                23, 'ت', 764,
                10, 1l ));

        result.add(new Vehicle(2l,
                46, 'ت', 234,
                10, 1l ));

        result.add(new Vehicle(1l,
                80, 'ت', 912,
                10, 1l ));

        return Response.success(result);
    }
}
