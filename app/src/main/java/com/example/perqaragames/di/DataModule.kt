package com.example.perqaragames.di

import com.example.perqaragames.data.local.database.dao.FavoritesDao
import com.example.perqaragames.data.remote.RawgAPIService
import com.example.perqaragames.data.repository.RawgRepository
import com.example.perqaragames.domain.repository.RawgRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRawgRepository(
        rawgAPIService: RawgAPIService,
        favoritesDao: FavoritesDao
    ): RawgRepository {
        return RawgRepositoryImpl(
            rawgAPIService,
            favoritesDao
        )
    }



}