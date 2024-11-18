package pe.mybusiness.walletapp.views.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import pe.mybusiness.walletapp.ui.theme.WalletAppTheme
import pe.mybusiness.walletapp.views.MainActivity

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WalletAppTheme {
               LoginView() {
                    val intent = Intent(this, MainActivity::class.java).apply {
                        flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                   startActivity(intent)
                   finish()
               }
            }
        }
    }
}
