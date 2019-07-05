package com.stackroute.service;

import com.stackroute.domain.Doctor;
import com.stackroute.exception.DoctorAlreadyExistsException;
import com.stackroute.exception.DoctorNotFoundException;
import com.stackroute.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public String save(Doctor doctor) {

        Optional optional=doctorRepository.findById(doctor.getEmailId());

        try {
            if (optional.isPresent()){
                throw new DoctorAlreadyExistsException("Doctor Already Exists");
            }
//            doctor.
            doctorRepository.save(doctor);
            return "Doctor Saved Successfully";
        } catch (DoctorAlreadyExistsException e) {
            return "Doctor Already Exists";
        }
    }

    @Override
    public String delete(String emailId) {
        Optional optional=doctorRepository.findById(emailId);

        try {
            if (optional.isPresent()){
                doctorRepository.deleteById(emailId);
                return "Deleted Successfully";
            }
            throw new DoctorNotFoundException("Doctor doesn't exists");
        } catch (DoctorNotFoundException e) {
            return "Doctor doesn't exists";
        }
    }

    @Override
    public String update(Doctor doctor) {
        Optional optional=doctorRepository.findById(doctor.getEmailId());

        try {
            if (optional.isPresent()){
                doctorRepository.save(doctor);

                return "Updated Successfully";
            }
            throw new DoctorNotFoundException("Doctor doesn't exists");
        } catch (DoctorNotFoundException e) {
            return "Doctor doesn't exists";
        }    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
}
