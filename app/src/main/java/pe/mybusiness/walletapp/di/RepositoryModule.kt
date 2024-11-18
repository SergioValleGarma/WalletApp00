package pe.mybusiness.walletapp.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.mybusiness.walletapp.repositories.CardRepository
import pe.mybusiness.walletapp.repositories.CardRepositoryImpl
import pe.mybusiness.walletapp.repositories.CurrencyRepository
import pe.mybusiness.walletapp.repositories.CurrencyRepositoryImpl
import pe.mybusiness.walletapp.repositories.TokenRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindCurrencyRepository(impl: CurrencyRepositoryImpl): CurrencyRepository

    @Binds
    abstract fun bindCardRepository(impl: CardRepositoryImpl): CardRepository
}


@InstallIn(SingletonComponent::class)
@Module
object TokenRepositoryModule {
    @Provides
    @Singleton
    fun provideTokenRepository(@ApplicationContext context: Context): TokenRepository {
        return TokenRepository(context)
    }
}