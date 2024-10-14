package pe.mybusiness.walletapp.data.repositories

import kotlinx.coroutines.flow.Flow
import pe.mybusiness.walletapp.data.models.Currency

interface CurrencyRepository {
    fun getCurrencies(): Flow<List<Currency>>
    suspend fun addCurrency(currency: Currency)
    suspend fun updCurrency(currency: Currency)
    suspend fun delCurrency(currency: Currency)
}