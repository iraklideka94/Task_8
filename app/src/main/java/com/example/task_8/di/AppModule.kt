package com.example.task_8.di

import android.content.Context
import com.example.task_8.common.ItemApiUtil
import com.example.task_8.data.ApiService
import com.example.task_8.data.OkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(@ApplicationContext context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ItemApiUtil.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.getInstance(context))
            .build()
    }

    @Provides
    @Singleton
    fun provideOutfitsApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}