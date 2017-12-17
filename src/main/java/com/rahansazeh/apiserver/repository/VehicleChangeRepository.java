package com.rahansazeh.apiserver.repository;

//import com.rahansazeh.apiserver.model.VehicleChangeEvent;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.List;
//
//public interface VehicleChangeRepository extends MongoRepository<VehicleChangeEvent, String> {
//    @Query(value = "{ 'projectId' : ?0 , 'epoch' : { '$gt' : ?1 } }", count = true)
//    long countByProjectIdAndEpoch(String projectId, Long epoch);
//
//    @Query(value = "{ 'projectId' : ?0 , 'epoch' : { '$gt' : ?1 } }")
//    Page<VehicleChangeEvent> getByProjectIdAndEpoch(String projectId, Long epoch, Pageable pageable);
//}
