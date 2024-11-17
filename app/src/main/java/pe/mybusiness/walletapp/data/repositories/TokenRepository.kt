package pe.mybusiness.walletapp.data.repositories

import android.content.Context
import android.content.SharedPreferences
import pe.mybusiness.walletapp.utils.AppConfig

class TokenRepository(context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(AppConfig.WALLET_PREFERENCES, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(AppConfig.FIREBASE_TOKEN, token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(AppConfig.FIREBASE_TOKEN, null)
    }
}