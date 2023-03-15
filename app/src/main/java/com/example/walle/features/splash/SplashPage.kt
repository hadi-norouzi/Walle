package com.example.walle.features.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.walle.navigation.Screen

@Composable
fun SplashPage(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Wallet")
        navController.navigate(Screen.Intro.route)
    }
}