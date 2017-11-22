package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.VehicleType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VehicleTypeController {
    @RequestMapping("/vehicleType/{projectLineId}")
    public Response<List<VehicleType>> getVehicleTypes(@PathVariable("projectLineId") Long projectLineId) {
        ArrayList<VehicleType> vehicleTypeList = new ArrayList<>();

        vehicleTypeList.add(new VehicleType(1l, "ون"));
        vehicleTypeList.add(new VehicleType(2l,"پژو (۴۰۵-روآ-آردی)"));
        vehicleTypeList.add(new VehicleType(3l,"سمند"));
        vehicleTypeList.add(new VehicleType(4l,"پیکان"));
        vehicleTypeList.add(new VehicleType(5l,"سایر"));

        return Response.success(vehicleTypeList);
    }
}
