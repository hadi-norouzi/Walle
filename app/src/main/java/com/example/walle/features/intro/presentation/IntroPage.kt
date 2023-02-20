package com.example.walle.features.intro.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun IntroPage(navController: NavController) {


    Scaffold {
        Column(
            modifier = Modifier
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