package pe.mybusiness.walletapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeNavigate(){
    val navController = rememberNavController()
    var showFloatingButton by remember { mutableStateOf(false) }
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            floatingActionButton = {
                if (showFloatingButton){
                    FloatingActionButton(onClick = {navController.navigate("addCurrency")}) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                    }
                }

            },
            bottomBar = {
                BottomBarView(navigateTo= {
                    when(it) {
                        "Home" -> {
                            showFloatingButton = false
                            navController.navigate("home")
                        }
                        "Wallet" ->{
                            showFloatingButton = true
                            navController.navigate("listCurrency")
                        }
                    }
                })
            },
            content = { padding ->
                NavHost(navController = navController, startDestination = "home"){
                    composable("home"){
                        showFloatingButton = false
                        HomeContentView(padding = padding)
                    }
                    composable("listCurrency"){
                        showFloatingButton = true
                        ListCurrencyView(
                            navigateToAddCurrency = { navController.navigate("addCurrency")}
                        )
                    }
                    composable("addCurrency"){
                        showFloatingButton = false
                        AddCurrencyView(
                            navigationToUp = { navController.navigateUp()}
                        )
                    }
                }
            }
        )
    }
}
/*fun CurrencyNavigate(){
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

}*/