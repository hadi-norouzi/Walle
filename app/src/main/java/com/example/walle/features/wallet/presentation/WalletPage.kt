package com.example.walle.features.wallet.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.walle.R
import com.example.walle.resources.WalleIcons
import me.onebone.toolbar.*
import org.koin.androidx.compose.koinViewModel


@Composable
fun WalletPage(
    viewModel: WalletViewModel = koinViewModel()
) {
    val currentWallet by viewModel.currentWallet.collectAsState()


    LaunchedEffect(key1 = currentWallet) {
//        when(currentWallet) {
//            WalletState.Empty ->
//            WalletState.Loading -> TODO()
//            is WalletState.Success -> TODO()
//        }
    }

    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    CollapsingToolbarScaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        state = rememberCollapsingToolbarScaffoldState(),
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        toolbar = {
            CollapsingToolbar(collapsingToolbarState = rememberCollapsingToolbarState()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(Icons.Default.Notifications, contentDescription = "")
                        }
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                painterResource(id = WalleIcons.Configure),
                                contentDescription = ""
                            )
                        }
                    }

                    Text("$10,000", style = MaterialTheme.typography.headlineLarge)
                    if (currentWallet is WalletState.Success) {
                        Text(
                            (currentWallet as WalletState.Success).wallet.name,
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        ActionButton(icon = WalleIcons.Send, title = "Send")
                        ActionButton(icon = WalleIcons.Receive, title = "Receive")
                        ActionButton(icon = WalleIcons.Buy, title = "Buy")
                        ActionButton(icon = WalleIcons.Swap, title = "Swap")
                    }

                }
            }

        },
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(items = list) { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
//                            navController.navigate("/phrase/import")
                        }
                        .padding(horizontal = 16.dp, vertical = 8.dp)


                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bitcoin),
                        contentDescription = "bit",
                        modifier = Modifier.size(36.dp)
                    )
                    Box(modifier = Modifier.width(8.dp))
                    Text("Bitcoin")
                }
            }
        }
    }
}

@Composable
fun ActionButton(icon: Int, title: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilledIconToggleButton(
            checked = true,
            enabled = true,
            onCheckedChange = {},
            colors = IconButtonDefaults.iconToggleButtonColors(
                checkedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                checkedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            ),
        ) {
            Icon(
                painterResource(id = icon),
                contentDescription = ""
            )
        }
        Text(title, style = MaterialTheme.typography.labelSmall)
    }
}


@Preview
@Composable
fun WalletPage_Preview() {
    WalletPage()
}

