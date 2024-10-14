package pe.mybusiness.walletapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.mybusiness.walletapp.data.models.Currency

@Database(entities = [Currency::class], version = 1, exportSchema = true)
abstract class AppDatabase:RoomDatabase() {
    abstract fun currencyDao():CurrencyDao
}