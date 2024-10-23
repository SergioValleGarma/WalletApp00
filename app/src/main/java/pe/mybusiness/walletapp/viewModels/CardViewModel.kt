package pe.mybusiness.walletapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import pe.mybusiness.walletapp.CardUiState
import pe.mybusiness.walletapp.data.repositories.CardRepository
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(private val cardRepository: CardRepository):ViewModel() {
    val cardsUiState: StateFlow<CardUiState> = cardRepository.getCards()
        .map { CardUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CardUiState()
        )
}