package com.dotech.erakulistest.data.repositories

import android.content.Context
import com.dotech.erakulistest.data.local.repositories.ImagesLocalRepo
import com.dotech.erakulistest.data.models.ImageDetails
import com.dotech.erakulistest.data.models.ImageDetailsResponse
import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.data.remote.apis.PixbayApi
import com.dotech.erakulistest.data.utils.Utils
import com.dotech.erakulistest.domain.models.Image
import com.dotech.erakulistest.domain.repositories.ImagesRepo
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ImagesRepoImpl @Inject constructor(
    private val api: PixbayApi,
    private val imagesLocalRepo: ImagesLocalRepo,
    private val context: Context
): ImagesRepo {

    override suspend fun getAllImages() = api.getImages(page = 1).hits

}