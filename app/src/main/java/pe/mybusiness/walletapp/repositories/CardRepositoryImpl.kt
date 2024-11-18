package pe.mybusiness.walletapp.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.mybusiness.walletapp.models.api.responses.Card
import pe.mybusiness.walletapp.services.restservices.CardService
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(private val cardService: CardService): CardRepository {
    override fun getCards(): Flow<List<Card>> {
        return flow {
            val cards = cardService.getCards()
            emit(cards)
        }
    }
}