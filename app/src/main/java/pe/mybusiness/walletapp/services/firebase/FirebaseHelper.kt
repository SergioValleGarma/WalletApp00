package pe.mybusiness.walletapp.services.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.mybusiness.walletapp.repositories.TokenRepository
import javax.inject.Inject

class FirebaseHelper @Inject constructor(private val tokenRepository: TokenRepository){
    private val auth = FirebaseAuth.getInstance()
    fun login(email:String, password:String):Flow<Boolean>{
        return flow{
            try {
                 val user = auth.signInWithEmailAndPassword(email, password)
                getCurrentUser()?.getIdToken(true)?.addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        tokenRepository.saveToken(task.result.token!!)
                    }
                }
                emit(true)
            }catch (e:Exception){
                emit(false)
            }
        }
    }
    fun getCurrentUser(): FirebaseUser?{
        return auth.currentUser
    }
}

