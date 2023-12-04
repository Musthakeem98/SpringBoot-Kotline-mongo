package com.example.demo.controller

import com.example.demo.model.Patient
import com.example.demo.repo.PatientRepo
import com.example.demo.services.PatientService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RestController
@RequestMapping("/api/patient")
class PatientController(private val patientService: PatientService) {

    @GetMapping
    fun getAllPatient(): List <Patient> = patientService.getAllPatient()

    @GetMapping("/{id}")
    fun getPatientByID(@PathVariable id : String): Patient? = patientService.getPatientById(id)

    @PostMapping
    fun savePatient(@RequestBody patient: Patient): Patient = patientService.savePatient(patient)

    @PutMapping("/{id}")
    fun updatePatient(@PathVariable id :String,@RequestBody patient: Patient): Patient =
        patientService.updatePatient(id, patient )

    @DeleteMapping("/{id}")
    fun deletePatient(@PathVariable id: String)  = patientService.deletePatient(id)

}