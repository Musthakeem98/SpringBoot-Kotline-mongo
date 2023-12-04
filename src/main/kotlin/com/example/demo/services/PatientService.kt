package com.example.demo.services

import com.example.demo.model.Patient
import com.example.demo.repo.PatientRepo
import org.springframework.stereotype.Service

@Service
class PatientService(private val  patientRepo: PatientRepo) {
    fun getAllPatient(): List<Patient> = patientRepo.findAll()

    fun getPatientById(id: String): Patient? = patientRepo.findById(id).orElse(null)

    fun savePatient(patient: Patient): Patient = patientRepo.save(patient)

    fun updatePatient(id: String, patient: Patient): Patient {
        require(id == patient.id) { "ID mismatch" }
        return patientRepo.save(patient)
    }

    fun deletePatient(id: String) {
        patientRepo.deleteById(id)
    }

}