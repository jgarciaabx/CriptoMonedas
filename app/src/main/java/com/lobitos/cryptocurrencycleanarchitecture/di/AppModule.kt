package com.lobitos.cryptocurrencycleanarchitecture.di

import com.lobitos.cryptocurrencycleanarchitecture.common.Constants
import com.lobitos.cryptocurrencycleanarchitecture.data.CoinPaprikaApi
import com.lobitos.cryptocurrencycleanarchitecture.data.remote.repository.CoinRepositoryImpl
import com.lobitos.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }


}