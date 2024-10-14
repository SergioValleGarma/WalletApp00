package pe.mybusiness.walletapp.data.repositories

import kotlinx.coroutines.flow.Flow
import pe.mybusiness.walletapp.data.local.CurrencyDao
import pe.mybusiness.walletapp.data.models.Currency
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(private  val currencyDao: CurrencyDao):CurrencyRepository {
    override fun getCurrencies(): Flow<List<Currency>> = currencyDao.getCurrencies()

    override suspend fun addCurrency(currency: Currency) = currencyDao.addCurrency(currency)

    override suspend fun updCurrency(currency: Currency) = currencyDao.updCurrancy(currency)

    override suspend fun delCurrency(currency: Currency) = currencyDao.delCurrency(currency)
}