package com.lobitos.cryptocurrencycleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lobitos.cryptocurrencycleanarchitecture.presentation.Screen
import com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_detail.CoinDetailScreen
import com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_list.CoinListScreen
import com.lobitos.cryptocurrencycleanarchitecture.presentation.ui.theme.CryptoCurrencyCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyCleanArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

