package com.rahansazeh.apiserver.repository;

import com.rahansazeh.apiserver.model.VehicleType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleTypeRepository extends MongoRepository<VehicleType, String> {
}
