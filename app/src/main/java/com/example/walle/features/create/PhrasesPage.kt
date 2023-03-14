package com.example.walle.features.create

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhrasesPage(
    viewModel: PhrasesViewModel = koinViewModel(),
    navController: NavController,
) {


    val clipboardManager: ClipboardManager = LocalClipboardManager.current


    Scaffold(
        topBar = {
            TopAppBar(
                actions = {

                    IconButton(
                        onClick = {
                            clipboardManager.setText(
                                AnnotatedString(
                                    viewModel.mnemonic.joinToString(
                                        " "
                                    )
                                )
                            )
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = com.example.walle.R.drawable.copy),
                            contentDescription = "Copy"
                        )
                    }

                },
                title = {

                    Text(text = "Phrases")
                },
            )
        },
        content = { padding ->

            Column(modifier = Modifier.padding(padding)) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = false,
                ) {
                    items(viewModel.mnemonic.size) {
                        Box(
                            Modifier
                                .clip(RoundedCornerShape(4.dp))
//                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                .background(Color.Gray)
                        ) {
                            Text(
                                text = viewModel.mnemonic[it],
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
                OutlinedButton(
                    onClick = {
                        viewModel.createWallet()
                        navController.navigate("/home") {
                            popUpTo("/intro") { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Continue")
                }
            }
        }
    )
}


@Preview
@Composable
fun PreviewPhrasePage() {
    PhrasesPage(

        navController = rememberNavController()
    )
}