package pe.mybusiness.walletapp.databases

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import pe.mybusiness.walletapp.models.entities.Currency

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currencies")
    fun getCurrencies(): Flow<List<Currency>>

    @Insert
    suspend fun addCurrency(currency: Currency)

    @Update
    suspend fun updCurrancy(currency: Currency)

    @Delete
    suspend fun delCurrency(currency: Currency)
}