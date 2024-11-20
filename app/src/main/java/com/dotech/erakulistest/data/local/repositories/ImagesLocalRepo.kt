package com.dotech.erakulistest.data.local.repositories

import com.dotech.erakulistest.data.local.dao.ImageDAO
import com.dotech.erakulistest.data.models.ImageDTO
import javax.inject.Inject

class ImagesLocalRepo @Inject constructor(private val imageDao: ImageDAO) {

    fun getAll(): List<ImageDTO> = imageDao.getAll()

    suspend fun insert(imageDTO: ImageDTO) = imageDao.insert(imageDTO)
    suspend fun insertAll(list: List<ImageDTO>) = imageDao.insertAll(list)
    suspend fun update(imageDTO: ImageDTO) = imageDao.update(imageDTO)
    suspend fun delete(imageDTO: ImageDTO) = imageDao.delete(imageDTO)
}