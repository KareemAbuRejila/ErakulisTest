package com.dotech.erakulistest.presentation.di

import android.content.Context
import androidx.room.Room
import com.dotech.erakulistest.BuildConfig
import com.dotech.erakulistest.data.local.AppDatabase
import com.dotech.erakulistest.data.local.dao.ImageDAO
import com.dotech.erakulistest.data.local.dao.UserDao
import com.dotech.erakulistest.data.local.repositories.ImagesLocalRepo
import com.dotech.erakulistest.data.remote.apis.PixbayApi
import com.dotech.erakulistest.data.repositories.ImagesRepoImpl
import com.dotech.erakulistest.data.repositories.UserRepoImpl
import com.dotech.erakulistest.domain.repositories.ImagesRepo
import com.dotech.erakulistest.domain.repositories.UserRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.nerdythings.okhttp.profiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGsonBuilderLenient(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(OkHttpProfilerInterceptor())
            .build()

    @Provides
    @Singleton
    fun providePixbayApiService(gsonClient: Gson, client: OkHttpClient): PixbayApi =
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(client)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonClient))
            .build()
            .create(PixbayApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun providePixbayDao(database: AppDatabase): ImageDAO = database.imageDao()
    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }
    @Provides
    @Singleton
    fun provideImagesRepo(
        @ApplicationContext context: Context, pixbayApi: PixbayApi, imagesLocalRepo: ImagesLocalRepo
    ): ImagesRepo {
        return ImagesRepoImpl(
            context = context, api = pixbayApi, imagesLocalRepo = imagesLocalRepo
        )
    }

}