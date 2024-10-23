package pe.mybusiness.walletapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun CurrencyNavigate(){
    val navHostController = rememberNavController()
    NavHost(navController =  navHostController, startDestination = "home"){
        composable(route = "home") {
            ListCurrencyView(navigateToAddCurrency = {
                navHostController.navigate("addCurrency")
            })
        }
        composable(route = "addCurrency") {
            AddCurrencyView(navigationToUp = {
                navHostController.navigateUp()
            })
        }
    }
    
}