package com.example.walle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.walle.features.intro.presentation.IntroPage
import com.example.walle.features.create.PhrasesPage
import com.example.walle.features.home.presentation.HomePage
import com.example.walle.features.import.presentation.ChooseCoinPage
import com.example.walle.features.import.presentation.ImportWalletPage
import com.example.walle.navigation.NavigationGraph
import com.example.walle.ui.theme.WalleTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        System.loadLibrary("TrustWalletCore")


        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            val darkTheme = isSystemInDarkTheme()

            DisposableEffect(systemUiController, darkTheme) {
                systemUiController.systemBarsDarkContentEnabled = !darkTheme
                onDispose {}
            }


            WalleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationGraph()
//                    NavHost(navController = navController, startDestination = "/intro") {
//
//                        composable("/intro") {
//                            IntroPage(navController)
//                        }
//                        composable("/phrase/create") {
//                            PhrasesPage(navController = navController)
//                        }
//                        composable(
//                            "/phrase/import?type={value}",
//                            arguments = listOf(
//                                navArgument("value") {
//                                    type = NavType.StringType
//                                },
//                            ),
//                        ) {
//                            ImportWalletPage(navController, it.arguments?.getString("value"))
//                        }
//                        composable("/home") {
//                            HomePage(navController)
//                        }
//                        composable("/qr_code") {
//                            QrCodeScanner(navController)
//                        }
//                        composable("/choose_currency") {
//                            ChooseCoinPage(navController)
//                        }
//
//
//                    }
                }
            }
        }
    }
}