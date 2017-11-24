package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.controller.error.NotFoundException;
import com.rahansazeh.apiserver.model.*;
import com.rahansazeh.apiserver.repository.*;
import com.rahansazeh.apiserver.utils.LicensePlateFormatter;
import com.rahansazeh.apiserver.utils.ObjectEquals;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    private VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    private ProjectLineRepository projectLineRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleChangeRepository changeRepository;

    @RequestMapping(path = "/dataentry/passenger", method = RequestMethod.POST)
    public Response<IdentifierResponse> recordPassenger(@Valid @RequestBody PassengerRecord request) throws Exception {
        User user = userRepository.findByNationalCode(request.getRequest_userName());
        Project project = projectRepository.findOne(request.getRequest_projectId());
        ProjectLine projectLine = projectLineRepository.findOne(request.getRequest_projectLineId());

        if (user == null) {
            throw new NotFoundException("user not found");
        }

        if (project == null) {
            throw new NotFoundException("project not found");
        }

        if (projectLine == null) {
            throw new NotFoundException("project line not found");
        }

        PassengerRecord record = passengerRecordRepository.findByClientId(request.getId());

        if (record == null) {
            record = passengerRecordRepository.save(new PassengerRecord(request.getClientId(),
                    request.getYear(), request.getMonth(), request.getDay(),
                    request.getStartHour(), request.getStartMinute(), request.getFinishHour(),
                    request.getFinishMinute(), request.getPassengerCount(), request.isHasSelectedHead()));

            record.setUser(user);
            record.setProject(project);
            record.setProjectLine(projectLine);

            passengerRecordRepository.save(record);
        }

        return Response.success(new IdentifierResponse(record.getId()));
    }

    @RequestMapping(path = "/dataentry/vehicle", method = RequestMethod.POST)
    public Response<IdentifierResponse> recordVehicle(@Valid @RequestBody VehicleRecord request) throws Exception {
        User user = userRepository.findByNationalCode(request.getRequest_userName());
        Project project = projectRepository.findOne(request.getRequest_projectId());
        ProjectLine projectLine = projectLineRepository.findOne(request.getRequest_projectLineId());

        if (user == null) {
            throw new NotFoundException("user not found");
        }

        if (project == null) {
            throw new NotFoundException("project not found");
        }

        if (projectLine == null) {
            throw new NotFoundException("project line not found");
        }

        VehicleRecord record = vehicleRecordRepository.findByClientId(request.getClientId());

        if (record == null) {
            VehicleType vehicleType = project.getVehicleTypes().stream()
                    .filter(x -> ObjectEquals.equals(x.getTitle(), request.getRequest_vehicleType()))
                    .findFirst()
                    .orElseGet(() -> {
                        VehicleType newVehicleType = vehicleTypeRepository.save(
                                new VehicleType(request.getRequest_vehicleType()));
                        project.addVehicleType(newVehicleType);
                        projectRepository.save(project);
                        return newVehicleType;
                    });

            LicensePlate licensePlate = LicensePlateFormatter.parseLicensePlate(request.getRequest_licensePlate());

            Vehicle vehicle = vehicleRepository.findByProjectAndLicensePlateLeftAndLicensePlateRightAndLicensePlateTypeAndLicensePlateNationalCode(
                    new ObjectId(project.getId()),
                    licensePlate.getLicensePlateLeft(),
                    licensePlate.getLicensePlateRight(),
                    licensePlate.getLicensePlateType(),
                    licensePlate.getLicensePlateNationalCode());

            if (vehicle == null) {
                vehicle = vehicleRepository.save(new Vehicle(licensePlate.getLicensePlateLeft(),
                        licensePlate.getLicensePlateType(),
                        licensePlate.getLicensePlateRight(), licensePlate.getLicensePlateNationalCode()));
                vehicle.setProject(project);
                vehicle.setVehicleType(vehicleType);

                vehicleRepository.save(vehicle);
                changeRepository.save(new VehicleChangeEvent(VehicleChangeEvent.EVENT_TYPE.ADD, vehicle));
            }

            record = vehicleRecordRepository.save(new VehicleRecord(request.getClientId(), request.isHasLoaded(),
                    request.isHasUnLoaded(), request.getYear(), request.getMonth(), request.getDay(),
                    request.isHasArrivalTime(), request.getArrivalTimeHour(), request.getArrivalTimeMinute(),
                    request.getArrivalTimeSecond(), request.isHasDepartureTime(),
                    request.getDepartureTimeHour(), request.getDepartureTimeMinute(),
                    request.getDepartureTimeSecond(),
                    request.getLoadPassengerCount(), request.getUnloadPassengerCount(),
                    request.isHasSelectedHeadTerminal()));

            record.setUser(user);
            record.setProject(project);
            record.setProjectLine(projectLine);

            vehicleRecordRepository.save(record);
        }

        return Response.success(new IdentifierResponse(record.getId()));
    }
}
