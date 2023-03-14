package com.example.walle.features.home.presentation

import androidx.core.os.trace
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions


class HomeViewModel: ViewModel() {


    fun navigateBottomBar(topLevelDestination: TopLevelDestination, navController: NavController) {

        // TODO: Trace
        val topLevelNavOption = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }

            launchSingleTop = true

            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.WALLET -> navController.navigate("/wallet", navOptions = topLevelNavOption)
            TopLevelDestination.DISCOVER -> navController.navigate("/discover", navOptions = topLevelNavOption)
            TopLevelDestination.SETTING -> navController.navigate("/settings", navOptions = topLevelNavOption)
        }
    }
}