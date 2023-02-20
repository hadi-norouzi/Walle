package com.example.walle.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.walle.BottomNavItem
import com.example.walle.features.discover.DiscoverPage
import com.example.walle.features.settings.SettingsPage
import com.example.walle.features.wallet.presentation.WalletPage


@Composable
fun HomePage(navController: NavController) {
    val homeNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {


                val items = listOf(
                    BottomNavItem.Wallet,
                    BottomNavItem.Discover,
                    BottomNavItem.Settings,
                )

                val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = item.icon),
                                contentDescription = item.title,
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 9.sp
                            )
                        },
                        modifier = Modifier.background(Color.Gray),
//                        selectedContentColor = Color.Black,
//                        unselectedContentColor = Color.Black.copy(0.4f),
//                        alwaysShowLabel = true,
                        selected = currentRoute == item.screenRoute,
                        onClick = {
                            homeNavController.navigate(item.screenRoute) {

                                homeNavController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )

                }
            }
        }
    ) {


        NavHost(
            navController = homeNavController,
            startDestination = "/wallet",
            modifier = Modifier.padding(it),
        ) {
            composable(BottomNavItem.Wallet.screenRoute) {
                WalletPage()
            }
            composable(BottomNavItem.Discover.screenRoute) {
                DiscoverPage()
            }
            composable(BottomNavItem.Settings.screenRoute) {
                SettingsPage()
            }
        }
    }
}