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
import com.example.walle.features.phrase.PhrasesPage
import com.example.walle.ui.theme.WalleTheme




class MainActivity : ComponentActivity() {
        
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        System.loadLibrary("TrustWalletCore")
        setContent {
            val navController = rememberNavController()
            WalleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    NavHost(navController = navController, startDestination = "home") {

                        composable("home") {
                            PhrasesPage()
                        }
                    }
                }
            }
        }
    }
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