package com.dotech.erakulistest.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dotech.erakulistest.data.local.dao.ImageDAO
import com.dotech.erakulistest.data.local.dao.UserDao
import com.dotech.erakulistest.data.models.ImageDTO
import com.dotech.erakulistest.data.models.User

@Database(entities = [ImageDTO::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun imageDao(): ImageDAO
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    AppDatabase::class.java.simpleName
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}