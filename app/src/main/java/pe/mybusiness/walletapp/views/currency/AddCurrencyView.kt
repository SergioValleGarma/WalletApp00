package pe.mybusiness.walletapp.views.currency

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import pe.mybusiness.walletapp.models.entities.Currency
import pe.mybusiness.walletapp.viewModels.CurrencyViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCurrencyView(
    navigationToUp:()->Unit,
    currencyViewModel: CurrencyViewModel= hiltViewModel()
){
    var name by remember { mutableStateOf("") }
    var sell by remember { mutableStateOf("") }
    var buy by remember { mutableStateOf("") }
    val coroutineScope= rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text="Add Currency")},
                navigationIcon = {
                    IconButton(onClick = navigationToUp) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .fillMaxSize()
        ) {
            OutlinedTextField(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                value = name,
                onValueChange = {name=it},
                label = { Text(text= "Currency Name") }
            )
            OutlinedTextField(modifier= Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                value =buy,
                onValueChange = {
                    if (it.isEmpty() || it.toFloatOrNull() != null) {
                        buy = it
                    }    },
                label = { Text(text = "Buy")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal
                )
            )
            OutlinedTextField(modifier= Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
                value = sell,    onValueChange = {
                    if (it.isEmpty() || it.toFloatOrNull() != null) {
                        sell = it
                    }    },
                label = { Text(text = "Sell")},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal
                )
            )

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                OutlinedButton(modifier = Modifier
                    .weight(1f,true),
                    onClick = navigationToUp)
                {
                    Text(text = "Cancel")
                }

                FilledTonalButton(modifier = Modifier
                    .weight(1f,true),
                    onClick = {
                        coroutineScope.launch {
                            currencyViewModel.addCurrency(
                                Currency(
                                    name = name,
                                    buy = buy.toFloat(),
                                    sell = sell.toFloat()
                                )
                            )
                        }
                        navigationToUp()
                    }
                ){
                    Text(text = "Save")
                }
            }
        }
    }
}