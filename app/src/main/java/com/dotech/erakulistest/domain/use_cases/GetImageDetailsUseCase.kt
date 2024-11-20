package com.dotech.erakulistest.domain.use_cases

import com.dotech.erakulistest.data.models.ImageDTO
import com.dotech.erakulistest.data.models.ImageDetails
import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.domain.repositories.ImagesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class GetImageDetailsUseCase  @Inject constructor(
    private val repo: ImagesRepo
) {

    operator fun invoke(imageId: String): Flow<Resource<ImageDetails>> = flow {
        try {
            emit(Resource.Loading())
//            val img = repo.getImage(imageId)
//            emit(Resource.Success(img))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Exception", data = null))
        } catch (e: SocketTimeoutException) {
            emit(Resource.Error(e.message ?: "SocketTimeoutException", data = null))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error Msg domain", data = null))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet Connection", data = null))
        }
    }
}