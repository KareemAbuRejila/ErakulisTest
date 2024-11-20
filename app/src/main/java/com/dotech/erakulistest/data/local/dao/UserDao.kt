package com.dotech.erakulistest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dotech.erakulistest.data.models.User

@Dao
interface UserDao {

    @Insert
    suspend fun registerUser(user: User): Long

    @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
    suspend fun login(email: String, password: String): User?

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun checkUserExists(email: String): User?

    @Query("UPDATE users SET token = :token WHERE email = :email")
    suspend fun updateUserToken(email: String, token: String)

    @Query("SELECT * FROM users WHERE token = :token LIMIT 1")
    suspend fun getUserByToken(token: String): User?
}