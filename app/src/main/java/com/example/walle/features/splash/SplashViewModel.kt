package com.example.walle.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.walle.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel constructor(val navController: NavController) : ViewModel() {
    init {
        checkWalletExist()
    }

    private fun checkWalletExist() {
        if (true) {
            navigateToIntro()

        } else {
            navigateToMain()
        }
    }

    private fun navigateToMain() {
        navController.navigate(Screen.Wallet.route)
    }

    private fun navigateToIntro() {
        viewModelScope.launch {
            delay(5000)
            navController.navigate(Screen.Intro.route)
        }
    }
}