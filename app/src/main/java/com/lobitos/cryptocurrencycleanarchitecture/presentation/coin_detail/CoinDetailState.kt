package com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_detail

import com.lobitos.cryptocurrencycleanarchitecture.domain.model.Coin
import com.lobitos.cryptocurrencycleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)