package com.lobitos.cryptocurrencycleanarchitecture.common

import android.util.Log

object Constants {

    const val BASE_URL = "https://api.coinpaprika.com/"

    const val PARAM_COIN_ID = "coinId"

    private const val TAG = "CustomTag" // Cambia esto según tu necesidad

    fun logi(message: String) {
        Log.i(TAG, message)
    }
}