package pe.mybusiness.walletapp.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.mybusiness.walletapp.data.models.Card
import pe.mybusiness.walletapp.data.services.CardService
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val cardService: CardService): CardRepository {
    override fun getCards(): Flow<List<Card>> {
        return flow {
            val cards = cardService.getCards()
            emit(cards)
        }
    }
}