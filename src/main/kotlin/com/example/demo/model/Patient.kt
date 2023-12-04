package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("appointment")
data class Patient(
    @Id
    val id : String? = null,
    val patientName: String,
    val idNumber: String,

)
