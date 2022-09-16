package com.example.task_8.di

import com.example.task_8.data.ItemsRepositoryImpl
import com.example.task_8.model.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindItemsRepositoryImpl(
        outfitsRepositoryImpl: ItemsRepositoryImpl
    ) : ItemsRepository

}