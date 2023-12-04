package com.example.demo.repo

import com.example.demo.model.Patient
import org.springframework.data.mongodb.repository.MongoRepository

interface PatientRepo : MongoRepository<Patient, String>