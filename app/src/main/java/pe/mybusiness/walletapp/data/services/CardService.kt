package pe.mybusiness.walletapp.data.services

import pe.mybusiness.walletapp.data.models.Card
import retrofit2.http.GET

interface CardService {
    @GET(".")
    suspend fun getCards(): List<Card>
}