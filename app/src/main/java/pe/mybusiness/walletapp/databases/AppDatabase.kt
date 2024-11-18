package pe.mybusiness.walletapp.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.mybusiness.walletapp.models.entities.Currency

@Database(entities = [Currency::class], version = 1, exportSchema = true)
abstract class AppDatabase:RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}