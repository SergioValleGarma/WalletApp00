package pe.mybusiness.walletapp.models.ui

import pe.mybusiness.walletapp.models.api.responses.Card

data class CardUiState (
    val cards:List<Card> = listOf()
){
}