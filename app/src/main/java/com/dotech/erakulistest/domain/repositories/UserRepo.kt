package com.dotech.erakulistest.domain.repositories


interface UserRepo {


    suspend fun logout(email:String):Boolean

}