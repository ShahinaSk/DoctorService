package com.stackroute.repository;

import com.stackroute.domain.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String> {
    /*db.inventory.updateOne(
   { item: "paper" },
   {
     $set: { "size.uom": "cm", status: "P" },
     $currentDate: { lastModified: true }
   }
)*/
    /*@Query()
    Doctor update(Doctor doctor);*/

}
