package com.dotech.erakulistest.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    val password: String, // Encrypted password
    val age: Int,
    val token: String? = null // Nullable to allow generation only after login
)