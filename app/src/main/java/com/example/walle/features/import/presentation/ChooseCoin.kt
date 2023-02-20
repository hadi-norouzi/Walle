package com.example.walle.features.import.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.walle.R

@Composable
fun ChooseCoinPage(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Choose Currency")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Gray)
                    .clickable {
                        navController.navigate("/phrase/import")
                    }
                    .padding(12.dp)


            ) {
                Image(
                    painter = painterResource(id = R.drawable.bitcoin),
                    contentDescription = "bit",
                    modifier = Modifier.size(40.dp)
                )
                Box(modifier = Modifier.width(8.dp))
                Text("Bitcoin")
            }

        }
    }
}

@Preview
@Composable
fun ChooseCoinPage_Preview() {
    ChooseCoinPage(rememberNavController())
}