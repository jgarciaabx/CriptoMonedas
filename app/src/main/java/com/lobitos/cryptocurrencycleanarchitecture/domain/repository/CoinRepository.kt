package com.lobitos.cryptocurrencycleanarchitecture.domain.repository

import com.lobitos.cryptocurrencycleanarchitecture.data.remote.dto.CoinDetailDto
import com.lobitos.cryptocurrencycleanarchitecture.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}