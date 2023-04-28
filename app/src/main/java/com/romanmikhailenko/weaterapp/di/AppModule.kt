package com.romanmikhailenko.weaterapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.romanmikhailenko.weaterapp.data.db.CityDatabase
import com.romanmikhailenko.weaterapp.data.repositories.remote.ApiService
import com.romanmikhailenko.weaterapp.utils.Constants.Companion.BASE_URL
import com.romanmikhailenko.weaterapp.utils.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.logging.HttpLoggingInterceptor
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrl() = BASE_URL

    @Provides
    fun logging() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(logging())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(ApiService::class.java)

    @Provides
    fun provideCityDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CityDatabase::class.java,
        "city_database"
    ).createFromAsset(DATABASE_NAME). build()

    @Provides
    fun provideCityDao(db : CityDatabase) = db.getCityDao()
}