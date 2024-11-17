package pe.mybusiness.walletapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.mybusiness.walletapp.data.services.CardService
import pe.mybusiness.walletapp.utils.AppConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule{
    //private const val BASE_URL= "https://localhost:7273/WeatherForecast/Get2/"
    ///private const val BASE_URL= "https://run.mocky.io/v3/3ab15913-4482-42bf-ad09-2db176385e37/"
    ////private const val BASE_URL="https://run.mocky.io/v3/95f069be-fb73-4aee-9674-6c26c13899c6/"

    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideCardService(retrofit: Retrofit): CardService {
        return retrofit.create(CardService::class.java)
    }
}

/* JSON para el mock

[
    {
        "cardType":"VISA",
        "cardNumber":"3664 7689 7773 3890",
        "cardName":"Business",
        "balance":"46.89",
        "startColor":"#FF7B1FA2",
        "endColor":"#FF806785"
    },
    {
        "cardType":"MASTER CARD",
        "cardNumber":"1234 7777 7773 9876",
        "cardName":"Savings",
        "balance":"789.89",
        "startColor":"#FF303F9F",
        "endColor":"#FF6C74A5"

    },
    {
        "cardType":"VISA",
        "cardNumber":"2345 9999 1111 8332",
        "cardName":"School",
        "balance":"467.99",
        "startColor":"#FFF57C00",
        "endColor":"#FFE4AE5F"
    },
    {
        "cardType":"MASTER CARD",
        "cardNumber":"3333 4444 6789 0321",
        "cardName":"Trips",
        "balance":"6789.89",
        "startColor":"#FF388E3C",
        "endColor":"#FFAABDAB"
    }
]
 */