package pe.mybusiness.walletapp.views.home.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import pe.mybusiness.walletapp.models.entities.Currency
import pe.mybusiness.walletapp.ui.theme.GreenStart
import pe.mybusiness.walletapp.viewModels.CurrencyViewModel

@Preview(showBackground = true)
@Composable
fun CurrenciesView(currencyViewModel: CurrencyViewModel = hiltViewModel()){
    val currencyUiState by currencyViewModel.currencyUiState.collectAsState()
    val currencyItems = currencyUiState.currencies

    var isVisible by remember { mutableStateOf(false) }
    var iconState by remember { mutableStateOf(Icons.Rounded.KeyboardArrowUp) }
    Box (modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Column(modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
        ) {
            Row(modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .clickable { isVisible = !isVisible
                        if (isVisible){
                            iconState = Icons.Rounded.KeyboardArrowUp
                        }else{
                            iconState = Icons.Rounded.KeyboardArrowDown
                        }

                    }
                ) {
                    Icon(modifier = Modifier
                        .size(25.dp),
                        imageVector = iconState,
                        contentDescription = "Currencies",
                        tint =MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.onSecondaryContainer)
            )
            if (isVisible){
               BoxWithConstraints(modifier = Modifier
                   .fillMaxSize()
                   .padding(horizontal = 16.dp)
                   .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                   .background(MaterialTheme.colorScheme.background)
               ) {
                   val boxWithConstraintsScope = this
                   val width = boxWithConstraintsScope.maxWidth / 3
                   Column(modifier = Modifier
                       .fillMaxWidth()
                       .padding(horizontal = 16.dp)
                   ) {
                       Spacer(modifier = Modifier.height(16.dp))
                       Row(modifier = Modifier
                           .fillMaxWidth()
                       ) {
                           Text(modifier = Modifier
                               .width(width),
                               text = "Currency",
                               fontWeight = FontWeight.SemiBold,
                               fontSize = 16.sp,
                               color = MaterialTheme.colorScheme.onBackground)
                           Text(modifier = Modifier
                               .width(width),
                               fontWeight = FontWeight.SemiBold,
                               fontSize = 16.sp,
                               color = MaterialTheme.colorScheme.onBackground,
                               text = "Buy",
                               textAlign = TextAlign.End)
                           Text(modifier = Modifier
                               .width(width),
                               fontWeight = FontWeight.SemiBold,
                               fontSize = 16.sp,
                               color = MaterialTheme.colorScheme.onBackground,
                               text = "Sell",
                               textAlign = TextAlign.End)
                       }
                       Spacer(modifier = Modifier.height(16.dp))
                       LazyColumn {
                           items(currencyItems.size){index ->
                           CurrencyItem(currencyItems[index],width)
                       }}
                   }
               }
            }
        }
    }
}

@Composable
fun CurrencyItem(currency: Currency, width: Dp){
    ///val currency = currencyItems[index]
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(modifier = Modifier
            .width(width),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)
            ){
                Icon(imageVector = Icons.Rounded.AttachMoney,
                    contentDescription = currency.name,
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
            Text(modifier = Modifier
                .padding(start = 10.dp),
                text = currency.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

        }
        Text(modifier = Modifier
            .width(width)
            .padding(start = 10.dp),
            text = "$ ${currency.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
        Text(modifier = Modifier
            .width(width)
            .padding(start = 10.dp),
            text = "$ ${currency.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
    }
}
/*
val currencyItems = listOf(
    Currency(
        id = 1,
        name = "USD",
        buy = 3.45f,
        sell = 3.97f
        ///icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        id = 2,
        name = "EUR",
        buy = 4.89f,
        sell = 5.54f
        ///icon = Icons.Rounded.Euro
    ),
    Currency(
        id = 3,
        name = "YEN",
        buy = 34.30f,
        sell = 38.20f
        ///icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        id = 4,
        name = "USD",
        buy = 3.45f,
        sell = 3.97f
        ///icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        id = 5,
        name = "EUR",
        buy = 4.89f,
        sell = 5.54f
        ///icon = Icons.Rounded.Euro
    ),
    Currency(
        id = 6,
        name = "YEN",
        buy = 34.30f,
        sell = 38.20f
        ///icon = Icons.Rounded.CurrencyYen
    )
)*/