package com.rahansazeh.apiserver.repository;

//import com.rahansazeh.apiserver.model.Vehicle;
//import org.bson.types.ObjectId;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.List;
//
//public interface VehicleRepository extends MongoRepository<Vehicle, String> {
//    @Query("{ 'project.$id' : ?0 }")
//    List<Vehicle> findByProject(ObjectId projectId, Pageable pageable);
//
//    @Query("{ 'project.$id' : ?0 }")
//    List<Vehicle> findByProject(ObjectId projectId);
//
//    @Query(value = "{ 'project.$id' : ?0 }", delete = true)
//    Long deleteAllByProject(ObjectId projectId);
//
//    @Query(value = "{ 'project.$id' : ?0 }", count = true)
//    long countByProject(ObjectId projectId);
//
//    @Query("{ 'project.$id' : ?0 , 'licensePlateLeft' : ?1 , 'licensePlateRight' : ?2 , 'licensePlateType' : ?3 , 'licensePlateNationalCode' : ?4 }")
//    Vehicle findByProjectAndLicensePlateLeftAndLicensePlateRightAndLicensePlateTypeAndLicensePlateNationalCode(
//            ObjectId projectId, int licensePlateLeft, int licensePlateRight,
//            char licensePlateType, int licensePlateNationalCode);
//}
