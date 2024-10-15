package pe.mybusiness.walletapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import pe.mybusiness.walletapp.viewModels.CurrencyViewModel

@Composable
fun AddCurrencyView(
    navigationToUp:()->Unit,
    currencyViewModel: CurrencyViewModel= hiltViewModel()
){
    var name by remember { mutableStateOf("") }
    var sell by remember { mutableStateOf("") }
    var buy by remember { mutableStateOf("") }
    val coroutineScope= rememberCoroutineScope()
}