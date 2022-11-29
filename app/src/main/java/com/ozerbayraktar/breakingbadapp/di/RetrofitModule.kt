package com.ozerbayraktar.breakingbadapp.di

import com.ozerbayraktar.breakingbadapp.data.source.BreakingBadApiService
import com.ozerbayraktar.breakingbadapp.util.Constans.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun injectRetrofitApi(): BreakingBadApiService =
             Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BreakingBadApiService::class.java)


}