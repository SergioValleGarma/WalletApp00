package pe.mybusiness.walletapp.data.repositories

import kotlinx.coroutines.flow.Flow
import pe.mybusiness.walletapp.data.models.Card

interface CardRepository {
    fun getCards(): Flow<List<Card>>
}