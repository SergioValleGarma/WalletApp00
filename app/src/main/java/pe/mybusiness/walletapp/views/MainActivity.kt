package pe.mybusiness.walletapp.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import pe.mybusiness.walletapp.ui.theme.WalletAppTheme
import pe.mybusiness.walletapp.views.navigator.HomeNavigate

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletAppTheme {
                HomeNavigate()
            }
        }
    }
}

