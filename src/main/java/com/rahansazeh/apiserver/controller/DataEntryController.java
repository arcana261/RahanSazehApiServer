package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.PassengerRecordEntryRequest;
import com.rahansazeh.apiserver.model.PassengerRecordEntryResponse;
import com.rahansazeh.apiserver.model.VehicleRecordEntryRequest;
import com.rahansazeh.apiserver.model.VehicleRecordEntryResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataEntryController {
    @RequestMapping(path = "/dataentry/passenger", method = RequestMethod.POST)
    public Response<PassengerRecordEntryResponse> recordPassenger(@RequestBody PassengerRecordEntryRequest request) {
        return Response.success(new PassengerRecordEntryResponse(0l));
    }

    @RequestMapping(path = "/dataentry/vehicle", method = RequestMethod.POST)
    public Response<VehicleRecordEntryResponse> recordVehicle(@RequestBody VehicleRecordEntryRequest request) {
        return Response.success(new VehicleRecordEntryResponse(0l));
    }
}
