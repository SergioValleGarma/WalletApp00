package pe.mybusiness.walletapp.services.restservices

import pe.mybusiness.walletapp.models.api.responses.Card
import retrofit2.http.GET

interface CardService {
    @GET(".")
    suspend fun getCards(): List<Card>
}