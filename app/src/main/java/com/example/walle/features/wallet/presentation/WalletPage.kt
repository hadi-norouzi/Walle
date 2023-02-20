package com.example.walle.features.wallet.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import org.koin.androidx.compose.koinViewModel


@Composable
fun WalletPage(

) {
    val viewModel: WalletViewModel = koinViewModel()
    val currentWallet = remember { viewModel.currentWallet.value }
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    CollapsingToolbarScaffold(
        state = rememberCollapsingToolbarScaffoldState(),
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {

            Column {

                Text("10,000")
                if (currentWallet != null) {
                    Text(currentWallet.name)
                }
                Row(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 12.dp)
                ) {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.Gray),
                    ) {
                        Icon(Icons.Default.Call, contentDescription = "")
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.Gray),
                    ) {
                        Icon(Icons.Default.Call, contentDescription = "")
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.Gray),
                    ) {
                        Icon(Icons.Default.Call, contentDescription = "")
                    }
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp))
                            .background(Color.Gray),
                    ) {
                        Icon(Icons.Default.Call, contentDescription = "")
                    }

                }

            }

        },
        modifier = Modifier
    ) {

        LazyColumn(modifier = Modifier.fillMaxWidth()) {

            items(items = list) { item ->
                Text(item)
            }
        }
    }
}


@Preview
@Composable
fun WalletPage_Preview() {
    WalletPage()
}

