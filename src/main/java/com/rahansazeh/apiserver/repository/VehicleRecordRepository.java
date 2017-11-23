package com.rahansazeh.apiserver.repository;

import com.rahansazeh.apiserver.model.VehicleRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRecordRepository extends MongoRepository<VehicleRecord, String> {
    VehicleRecord findByClientId(String clientId);
}
