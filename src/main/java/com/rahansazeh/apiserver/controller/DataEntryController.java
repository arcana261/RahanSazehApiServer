package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.*;
import com.rahansazeh.apiserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataEntryController {
    @Autowired
    private VehicleRecordRepository vehicleRecordRepository;

    @Autowired
    private PassengerRecordRepository passengerRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectLineRepository projectLineRepository;

    @RequestMapping(path = "/dataentry/passenger", method = RequestMethod.POST)
    public Response<PassengerRecordEntryResponse> recordPassenger(@RequestBody PassengerRecordEntryRequest request) {
        User user = userRepository.findByNationalCode(request.getUserName());
        Project project = projectRepository.findOne(request.getProjectId());
        ProjectLine projectLine = projectLineRepository.findOne(request.getProjectLineId());

        if (user == null || project == null || projectLine == null) {
            return Response.error(new Exception("item not found"));
        }

        PassengerRecord record = passengerRecordRepository.findByClientId(request.getId());

        if (record == null) {
            record = passengerRecordRepository.save(new PassengerRecord(request.getId(),
                    request.getYear(), request.getMonth(), request.getDay(),
                    request.getStartHour(), request.getStartMinute(), request.getFinishHour(),
                    request.getFinishMinute(), request.getPassengerCount(), request.isHasSelectedHead()));

            record.setUser(user);
            record.setProject(project);
            record.setProjectLine(projectLine);

            passengerRecordRepository.save(record);
        }

        return Response.success(new PassengerRecordEntryResponse(record.getId()));
    }

    @RequestMapping(path = "/dataentry/vehicle", method = RequestMethod.POST)
    public Response<VehicleRecordEntryResponse> recordVehicle(@RequestBody VehicleRecordEntryRequest request) {
        User user = userRepository.findByNationalCode(request.getUserName());
        Project project = projectRepository.findOne(request.getProjectId());
        ProjectLine projectLine = projectLineRepository.findOne(request.getProjectLineId());

        if (user == null || project == null || projectLine == null) {
            return Response.error(new Exception("item not found"));
        }

        VehicleRecord record = vehicleRecordRepository.findByClientId(request.getId());

        if (record == null) {
            record = vehicleRecordRepository.save(new VehicleRecord(request.getId(), request.isHasLoaded(),
                request.isHasUnLoaded(), request.getYear(), request.getMonth(), request.getDay(),
                request.isHasArrivalTime(), request.getArrivalTimeHour(), request.getArrivalTimeMinute(),
                request.getArrivalTimeSecond(), request.isHasDepartureTime(),
                request.getDepartureTimeHour(), request.getDepartuerTimeMinute(),
                request.getDepartureTimeSecond(),
                request.getLoadPassengerCount(), request.getUnloadPassengerCount(),
                request.isHasSelectedHeadTerminal()));

            record.setUser(user);
            record.setProject(project);
            record.setProjectLine(projectLine);

            vehicleRecordRepository.save(record);
        }

        return Response.success(new VehicleRecordEntryResponse(record.getId()));
    }
}
