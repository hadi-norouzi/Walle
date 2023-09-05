package com.example.walle.features.discover.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverPage(navController: NavController, viewModel: DiscoveryViewModel = koinViewModel()) {


    val histories = viewModel.browsingHistory.collectAsState(initial = listOf())

    val search = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = search.value,
            onValueChange = { value ->
                search.value = value
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text("Search website", style = MaterialTheme.typography.labelSmall)
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "")
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = {
                    navController.navigate("/web_browser?url=${search.value}")
                },
            )
        )
        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(histories.value) {

                HistoryItem(
                    history = it,
                    onTap = {
                        navController.navigate("/web_browser?url${it.url}")
                    },
                )
            }
        }
    }

}

@Preview
@Composable
fun DiscoverPage_Preview() {
    DiscoverPage(rememberNavController())
}