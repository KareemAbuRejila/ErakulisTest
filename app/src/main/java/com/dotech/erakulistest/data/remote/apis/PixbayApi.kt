package com.dotech.erakulistest.data.remote.apis

import com.dotech.erakulistest.BuildConfig
import com.dotech.erakulistest.data.models.ImageDTO
import com.dotech.erakulistest.data.models.ImageDetails
import com.dotech.erakulistest.data.models.ImageDetailsResponse
import com.dotech.erakulistest.data.models.PixBayResponse
import com.dotech.erakulistest.data.remote.Constrains.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixbayApi {
    @GET(API)
    suspend fun getImagess(
        @Query("key") apiKey: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20
    ): ImageDTO
    @GET(API)
    suspend fun getImages(
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 20
    ): PixBayResponse

    @GET(API)
    fun getImage(
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("imageId") imageId: String
        ): ImageDetailsResponse
}