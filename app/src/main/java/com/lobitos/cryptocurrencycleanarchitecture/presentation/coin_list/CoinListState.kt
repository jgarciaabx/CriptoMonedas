package com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_list

import com.lobitos.cryptocurrencycleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)