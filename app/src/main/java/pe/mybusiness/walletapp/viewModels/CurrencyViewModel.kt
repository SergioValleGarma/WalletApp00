package pe.mybusiness.walletapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import pe.mybusiness.walletapp.CurrencyUiState
import pe.mybusiness.walletapp.data.models.Currency
import pe.mybusiness.walletapp.data.repositories.CurrencyRepository
import javax.inject.Inject

class CurrencyViewModel @Inject constructor(private val currencyRepository: CurrencyRepository):ViewModel() {

    companion object{
        private const val MILLIS = 5_000L
    }
    val currencyUiState: StateFlow<CurrencyUiState> =
        currencyRepository.getCurrencies()
            .map { CurrencyUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(MILLIS),
                initialValue = CurrencyUiState()
            )

    suspend fun addCurrency(currency: Currency){
        viewModelScope.launch {
            currencyRepository.addCurrency(currency)
        }
    }
    suspend fun updCurrency(currency: Currency){
        viewModelScope.launch {
            currencyRepository.updCurrency(currency)
        }
    }
    suspend fun delCurrency(currency: Currency){
        viewModelScope.launch {
            currencyRepository.delCurrency(currency)
        }
    }
}