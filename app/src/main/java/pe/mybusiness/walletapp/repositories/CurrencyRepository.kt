package pe.mybusiness.walletapp.repositories

import kotlinx.coroutines.flow.Flow
import pe.mybusiness.walletapp.models.entities.Currency

interface CurrencyRepository {
    fun getCurrencies(): Flow<List<Currency>>
    suspend fun addCurrency(currency: Currency)
    suspend fun updCurrency(currency: Currency)
    suspend fun delCurrency(currency: Currency)
}