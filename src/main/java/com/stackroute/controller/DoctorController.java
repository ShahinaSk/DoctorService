package com.stackroute.controller;

import com.stackroute.domain.Doctor;
import com.stackroute.exception.DoctorAlreadyExistsException;
import com.stackroute.exception.DoctorNotFoundException;
import com.stackroute.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("doctor")
    public ResponseEntity<?> save(@RequestBody Doctor doctor) {

        String status=null;
        try {
            status=doctorService.save(doctor);
          return new ResponseEntity<String>(status, HttpStatus.CREATED);

        } catch (DoctorAlreadyExistsException e) {
            return new ResponseEntity<String>("Doctor Already Exists",HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("doctor/{emailId}")
    public ResponseEntity<?> delete(@PathVariable String emailId) {

        return new ResponseEntity<String>(doctorService.delete(emailId), HttpStatus.OK);
    }

    @PutMapping("doctor/{id}")
    public ResponseEntity<?> updateDoctorDetails(@RequestBody Doctor doctor) {

        ResponseEntity responseEntity;
        try{
            return new ResponseEntity<String>(doctorService.update(doctor),HttpStatus.OK);
        } catch (DoctorNotFoundException e) {
            return new ResponseEntity<String>("Doctor doesn't exist",HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("doctors")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<List<Doctor>>(doctorService.getAll(),HttpStatus.OK);
    }
}
