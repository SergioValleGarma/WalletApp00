package pe.mybusiness.walletapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
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
}

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













