// src/main/kotlin/com/example/demo/model/Book.kt
package com.example.demo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
data class Book(
    @Id
    val id: String? = null,
    val title: String,
    val author: String,
    val price: Double
)

data class MinBook(
    val title : String,
    val price : Double
)
