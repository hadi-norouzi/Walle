package com.example.walle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.walle.features.intro.presentation.IntroPage
import com.example.walle.features.create.PhrasesPage
import com.example.walle.features.home.HomePage
import com.example.walle.features.import.presentation.ChooseCoinPage
import com.example.walle.features.import.presentation.ImportWalletPage
import com.example.walle.features.wallet.presentation.WalletPage
import com.example.walle.ui.theme.WalleTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        System.loadLibrary("TrustWalletCore")
        setContent {
            val navController = rememberNavController()

//            val systemUi = remember
            WalleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    NavHost(navController = navController, startDestination = "/intro") {

                        composable("/intro") {
                            IntroPage(navController)
                        }
                        composable("/phrase/create") {
                            PhrasesPage(navController = navController)
                        }
                        composable("/phrase/import") {
                            ImportWalletPage(navController, it.arguments?.getString("iso"))
                        }
                        composable("/home") {
                            HomePage(navController)
                        }
                        composable("/qr_code") {
                            QrCodeScanner(navController)
                        }
                        composable("/choose_currency") {
                            ChooseCoinPage(navController)
                        }


                    }
                }
            }
        }
    }
}

sealed class BottomNavItem(var title: String, var icon: Int, var screenRoute: String) {

    object Wallet : BottomNavItem("Wallet", R.drawable.ic_wallet, "/wallet")

    object Discover : BottomNavItem("Discover", R.drawable.compass_ic, "/discover")

    //    object Browse : BottomNavItem("Browse", R.drawable.ic_post, "/browse")
    object Settings : BottomNavItem("Settings", R.drawable.settings_ic, "/settings")
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WalleTheme {
        Greeting("Android")
    }
}