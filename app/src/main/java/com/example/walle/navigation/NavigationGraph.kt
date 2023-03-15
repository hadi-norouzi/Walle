package com.example.walle.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.walle.features.create.PhrasesPage
import com.example.walle.features.import.presentation.ChooseCoinPage
import com.example.walle.features.intro.presentation.IntroPage
import com.example.walle.features.splash.SplashPage
import com.example.walle.navigation.NavigationItem
import com.example.walle.navigation.Screen

@Composable
fun NavigationGraph() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route){
        composable(Screen.Splash.route){
            SplashPage(navController=navController)
        }
        composable(Screen.Intro.route){
            IntroPage(navController=navController)
        }
        composable(Screen.CreatePhrase.route){
            PhrasesPage(navController=navController)
        }
        composable(Screen.ChooseCoin.route){
            ChooseCoinPage(navController=navController)
        }
    }
}