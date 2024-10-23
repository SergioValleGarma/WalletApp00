package pe.mybusiness.walletapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.mybusiness.walletapp.data.repositories.CardRepository
import pe.mybusiness.walletapp.data.repositories.CardRepositoryImpl
import pe.mybusiness.walletapp.data.repositories.CurrencyRepository
import pe.mybusiness.walletapp.data.repositories.CurrencyRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCurrencyRepository(impl: CurrencyRepositoryImpl): CurrencyRepository

    @Binds
    abstract fun bindCardRepository(impl: CardRepositoryImpl): CardRepository
}