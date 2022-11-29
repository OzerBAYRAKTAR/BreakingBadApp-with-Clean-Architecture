package com.ozerbayraktar.breakingbadapp.di

import com.ozerbayraktar.breakingbadapp.data.source.BreakingBadApiService
import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import com.ozerbayraktar.breakingbadapp.data.repository.BreakingBadRepositoryImp
import com.ozerbayraktar.breakingbadapp.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun injectRep(remoteDataSource: RemoteDataSource): BreakingBadRepository =
        BreakingBadRepositoryImp(remoteDataSource)
}