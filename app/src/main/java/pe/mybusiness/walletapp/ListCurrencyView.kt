package pe.mybusiness.walletapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import pe.mybusiness.walletapp.data.models.Currency
import pe.mybusiness.walletapp.viewModels.CurrencyViewModel

@Composable
fun ListCurrencyView(
    navigateToAddCurrency:()->Unit,
    currencyViewModel: CurrencyViewModel= hiltViewModel()
){
  val currenciesUiState by currencyViewModel.currencyUiState.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToAddCurrency) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerPadding->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CurrencyList(
                modifier = Modifier.padding(16.dp).fillMaxSize(),
                currencies = currenciesUiState.currencies
            )

        }

    }
}

@Composable
fun CurrencyList(
    modifier : Modifier
        ,currencies:List<Currency>
){
    if (currencies.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "No Currencies")
        }
    }else{
        LazyColumn(modifier = modifier,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(currencies){currency ->
                Surface(modifier=Modifier
                    .fillMaxWidth(),
                    shadowElevation = 4.dp
                ) {
                    Column {
                        Text(text = currency.name,
                            style = TextStyle(fontWeight = FontWeight.Bold,
                                fontSize = 15.sp)
                            )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = currency.sell.toString(),
                            style = TextStyle(fontSize = 15.sp,
                                color = Color.Gray)
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(text = currency.buy.toString(),
                            style = TextStyle(fontSize = 15.sp),
                            color = Color.Gray
                            )
                    }
                }

            }
        }
    }
}