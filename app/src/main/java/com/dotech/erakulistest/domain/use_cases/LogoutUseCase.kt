package com.dotech.erakulistest.domain.use_cases

import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.domain.repositories.UserRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val userRepo: UserRepo
) {

    operator fun invoke(email:String): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading())
            userRepo.logout(email)
            emit(Resource.Success(true))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Exception", data = null))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet Connection", data = null))
        }
    }
}