package com.stackroute.service;

import com.stackroute.domain.Doctor;
import com.stackroute.exception.DoctorAlreadyExistsException;
import com.stackroute.exception.DoctorNotFoundException;

import java.util.List;

public interface DoctorService {
    String save(Doctor doctor) throws DoctorAlreadyExistsException;
    String delete(String emailId);
    String update(Doctor doctor) throws DoctorNotFoundException;
    List<Doctor> getAll();
}
