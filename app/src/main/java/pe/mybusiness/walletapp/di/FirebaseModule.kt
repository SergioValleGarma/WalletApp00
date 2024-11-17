package pe.mybusiness.walletapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.mybusiness.walletapp.data.repositories.TokenRepository
import pe.mybusiness.walletapp.utils.FirebaseHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirebaseHelper(tokenRepository: TokenRepository): FirebaseHelper {
        return FirebaseHelper(tokenRepository)
    }
}