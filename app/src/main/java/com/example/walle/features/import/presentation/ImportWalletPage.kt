package com.example.walle.features.import.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults.textFieldColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.material3.OutlinedButton as MaterialOutlinedButton
import androidx.compose.material3.TextField as MaterialTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImportWalletPage(
    navController: NavController,
    iso: String?,
    viewModel: ImportViewModel = viewModel()
) {

    val state = viewModel.state.collectAsState().value

    val phraseError by remember { mutableStateOf(viewModel.validatePhrases()) }

    if (state is ImportState.Success) {

        LaunchedEffect(Unit) {
            navController.navigate("/home") {
                popUpTo("/intro") { inclusive = true }
            }
        }
    }


    Scaffold(
        topBar = {

            TopAppBar(
                title = {
                    Text("Import $iso")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                actions = {

                    IconButton(onClick = { navController.navigate("/qr_code") }) {
                        Icon(
                            painter = painterResource(id = com.example.walle.R.drawable.scan),
                            contentDescription = "Qrcode",
                            modifier = Modifier
                                .size(30.dp)
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it).padding(16.dp)) {
            MaterialTextField(
                value = viewModel.walletName,
                onValueChange = {
                    viewModel.walletName = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(8.dp),
                singleLine = true,
                colors = textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                label = {
                    Text("Wallet name")
                }
            )
            MaterialTextField(
                value = viewModel.phrases,
                onValueChange = {
                    viewModel.phrases = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .height(160.dp),
                shape = RoundedCornerShape(8.dp),
                maxLines = 5,
                singleLine = false,
                colors = textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                trailingIcon = {
                    Text(
                        "PASTE",
                        modifier = Modifier
                            .clickable {
                                viewModel.pasteMnemonic()
                            }
                            .padding(end = 12.dp),
                    )
                },
                isError = phraseError,
                placeholder = {
                    Text("Phrase")
                },
            )
            Text("Insert 12 or 24 word phrases")
            MaterialOutlinedButton(
                onClick = {
                    if (viewModel.validatePhrases()) {
                        viewModel.importWallet()
                    }
                },
            ) {
                if (state is ImportState.Loading) {
                    CircularProgressIndicator()
                } else {
                    Text("Import")
                }
            }
        }
    }
}

@Preview
@Composable
fun ImportWallet_Preview() {
    ImportWalletPage(navController = rememberNavController(), "Dodge")
}