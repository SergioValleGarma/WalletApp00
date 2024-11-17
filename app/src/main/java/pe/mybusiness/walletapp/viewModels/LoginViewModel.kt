package pe.mybusiness.walletapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.mybusiness.walletapp.utils.FirebaseHelper
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val firebaseHelper: FirebaseHelper):ViewModel() {
    private val _loginResult = MutableStateFlow<Boolean>(false)
    val loginResult: StateFlow<Boolean> = _loginResult

    fun login(email:String, password:String){
        viewModelScope.launch {
            firebaseHelper.login(email,password).collect {
                result ->
                _loginResult.value = result
            }
        }
    }
}