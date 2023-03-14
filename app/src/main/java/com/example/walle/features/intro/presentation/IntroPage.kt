package com.example.walle.features.intro.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroPage(navController: NavController) {


    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()


        ) {
//            Image(
//                painter = painterResource(id = com.example.walle.R.drawable.bitcoin),
//                contentDescription = "",
//                modifier = Modifier.weight(1f).size(30.dp)
//            )
            Box(modifier = Modifier.weight(1f)) {

            }
            Column(modifier = Modifier.padding(16.dp)) {
                OutlinedButton(
                    onClick = {
                        navController.navigate("/phrase/create")
                    },
                    modifier = Modifier.fillMaxWidth(1f),
                ) {
                    Text(text = "Create a new wallet")
                }
                OutlinedButton(
                    onClick = {
                        navController.navigate("/choose_currency")

                    },
                    modifier = Modifier.fillMaxWidth(1f),
                ) {
                    Text("Import your wallet")
                }
            }
        }
    }
}

@Preview
@Composable
fun IntroPage_Preview() {

    IntroPage(rememberNavController())
}