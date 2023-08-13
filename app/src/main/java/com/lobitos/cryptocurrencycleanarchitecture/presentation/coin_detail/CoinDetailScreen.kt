package com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.lobitos.cryptocurrencycleanarchitecture.presentation.Screen
import com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_detail.components.CoinTag
import com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_detail.components.TeamListItem
import com.lobitos.cryptocurrencycleanarchitecture.presentation.coin_list.components.CoinListItem

@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        state.coin?.let {coin ->
            LazyColumn(modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                item{
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(8f)
                        )
                        Text(text = if(coin.isActive) "active" else "inactive",
                            style = MaterialTheme.typography.bodyMedium,
                            color = if(coin.isActive) Color.Green else Color.Red,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(text = coin.description,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(text = "Tags",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp
                    ){
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.padding(15.dp))
                    Text(text = "Team members",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                    Spacer(modifier = Modifier.padding(15.dp))
                }
                itemsIndexed(coin.team) { index, teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    Divider()
                }
            }
        }

        if(state.error.isNotBlank()){
            Text(text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp)
                    .align(alignment = Alignment.Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}