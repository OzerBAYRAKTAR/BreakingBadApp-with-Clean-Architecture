package com.ozerbayraktar.breakingbadapp.di

import com.ozerbayraktar.breakingbadapp.data.source.BreakingBadApiService
import com.ozerbayraktar.breakingbadapp.data.source.RemoteDataSourceImplement
import com.ozerbayraktar.breakingbadapp.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(dataService:BreakingBadApiService): RemoteDataSource=
        RemoteDataSourceImplement(dataService)

}