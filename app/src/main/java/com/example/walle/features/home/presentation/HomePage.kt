package com.example.walle.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.walle.features.discover.presentation.DiscoverPage
import com.example.walle.features.settings.SettingsPage
import com.example.walle.features.settings.WalletsPage
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walle.features.discover.presentation.WebBrowser
import com.example.walle.features.wallet.presentation.WalletPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(navController: NavController, viewModel: HomeViewModel = viewModel()) {
    val homeNavController = rememberNavController()


    val currentDestination: NavDestination? = homeNavController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination? = null
//        @Composable get() = when(currentDestination?.route) {
//
//        }
    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        bottomBar = {
            WalleBottomBar(
                modifier = Modifier.background(MaterialTheme.colorScheme.onBackground),
                destination = TopLevelDestination.values().asList(),
                currentDestination = currentDestination,
                onNavigateToDestination = {
                    viewModel.navigateBottomBar(it, homeNavController)
                }
            )
        }
    ) {


        NavHost(
            navController = homeNavController,
            startDestination = "/wallet",
            modifier = Modifier.padding(it),
        ) {
            composable("/wallet") {
                WalletPage()
            }
            composable("/discover") {
                DiscoverPage(homeNavController)
            }
            composable("/settings") {
                SettingsPage(homeNavController)
            }
            composable("/wallets") {
                WalletsPage()
            }
            composable("/web_browser") {
                WebBrowser(homeNavController, "https://google.com/search?q=hello")
            }
        }
    }
}