package com.dotech.erakulistest.data.repositories

import com.dotech.erakulistest.data.local.dao.UserDao
import com.dotech.erakulistest.data.models.Resource
import com.dotech.erakulistest.data.utils.SessionManager
import com.dotech.erakulistest.domain.repositories.UserRepo
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userDao: UserDao,
    private val sessionManager: SessionManager
) : UserRepo {


    override suspend fun logout(email: String): Boolean {
        try {
            userDao.updateUserToken(email, "")
            sessionManager.clearSession()
            return true
        } catch (e: IOException) {
            return false
        }
    }

}