package pe.mybusiness.walletapp.repositories

import kotlinx.coroutines.flow.Flow
import pe.mybusiness.walletapp.models.api.responses.Card

interface CardRepository {
    fun getCards(): Flow<List<Card>>
}