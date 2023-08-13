package com.lobitos.cryptocurrencycleanarchitecture.data.remote.repository

import com.lobitos.cryptocurrencycleanarchitecture.data.CoinPaprikaApi
import com.lobitos.cryptocurrencycleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins() = api.getCoins()

    override suspend fun getCoinById(coinId: String) = api.getCoinById(coinId)

}