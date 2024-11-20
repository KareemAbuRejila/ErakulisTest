package com.dotech.erakulistest.domain.repositories

import com.dotech.erakulistest.data.models.ImageDTO
import com.dotech.erakulistest.data.models.ImageDetails
import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.domain.models.Image
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface ImagesRepo {


    suspend fun getAllImages(): List<ImageDTO>

}