package com.dotech.erakulistest.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dotech.erakulistest.data.models.ImageDTO

@Dao
interface ImageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(imageDTO: ImageDTO)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<ImageDTO>)

    @Update
    suspend fun update(imageDTO: ImageDTO)

    @Delete
    suspend fun delete(imageDTO: ImageDTO)

    @Query("SELECT * FROM image_table")
    fun getAll(): List<ImageDTO>

    @Query("SELECT * FROM image_table WHERE id LIKE :imageId")
    fun getOne(imageId: String): ImageDTO
}