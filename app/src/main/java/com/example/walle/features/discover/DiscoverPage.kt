package com.example.walle.features.discover

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverPage() {

    val search = remember { mutableStateOf("") }


    Column(modifier = Modifier.padding(8.dp)) {
        TextField(
            value = search.value,
            onValueChange = { value ->
                search.value = value
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text("Search website")
            }
        )
    }

}

@Preview
@Composable
fun DiscoverPage_Preview() {
    DiscoverPage()
}