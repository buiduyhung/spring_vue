package com.api.backend.controller;

import com.api.backend.model.Patient;
import com.api.backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/")
    public String hello(){
        return "Hello world";
    }

    // add Patient
    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);

        return "Patient Added Successfully";
    }

    // getPatientById
    @RequestMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable("id") Long id){
        return patientService.getPatientById(id);
    }

    // getPatients
    @RequestMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    // updatePatients
    @PutMapping("/patient")
    public Patient updatePatients(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    // deletePatientById
    @DeleteMapping("/patient/{id}")
    public String deletePatientById(@PathVariable("id") long id){
        patientService.deletePatient(id);
        return "Patient Deleted";
    }

}


























