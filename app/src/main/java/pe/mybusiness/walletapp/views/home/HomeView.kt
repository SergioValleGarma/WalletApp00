package pe.mybusiness.walletapp.views.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.mybusiness.walletapp.views.home.components.CardsView
import pe.mybusiness.walletapp.views.home.components.CurrenciesView
import pe.mybusiness.walletapp.views.home.components.FinanceView
import pe.mybusiness.walletapp.views.home.components.HeaderView


/*@Preview(showBackground = true)
@Composable
fun HomeView(){
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            bottomBar = { BottomBarView()},
            content = {paddingValues ->
                HomeContentView(paddingValues)
            }
        )
    }
}*/

@Composable
fun HomeContentView(padding: PaddingValues){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(padding)
    ){
        HeaderView()
        CardsView()
        Spacer(modifier = Modifier.height(16.dp))
        FinanceView()
        CurrenciesView()

    }
}













