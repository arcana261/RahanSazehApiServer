package com.rahansazeh.apiserver.repository;

import com.rahansazeh.apiserver.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
