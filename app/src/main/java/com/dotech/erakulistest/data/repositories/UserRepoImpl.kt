package com.dotech.erakulistest.data.repositories

import com.dotech.erakulistest.data.local.dao.UserDao
import com.dotech.erakulistest.domain.repositories.UserRepo
import javax.inject.Inject

class UserRepoImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepo {


    override suspend fun logout(email:String) {
        userDao.updateUserToken(email, "")

    }

}