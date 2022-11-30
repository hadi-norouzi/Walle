package com.example.walle.features.phrase

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhrasesPage() {

    val viewModel: PhrasesViewModel = viewModel()

    val clipboardManager: ClipboardManager = LocalClipboardManager.current


    Scaffold(
        topBar = {
            TopAppBar(
                actions = {

                    Button(
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
                        Icon(imageVector = Icons.Filled.ThumbUp, contentDescription = "")

                    }

                },
                title = {

                    Text(text = "Phrases")
                },
            )
        }
    ) {

       Column {
           LazyVerticalGrid(
               cells = GridCells.Fixed(3),
               contentPadding = PaddingValues(12.dp),
               verticalArrangement = Arrangement.spacedBy(10.dp),
               horizontalArrangement = Arrangement.spacedBy(10.dp),
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
           OutlinedButton(onClick = { /*TODO*/ }) {
               Text("Continue")
           }
       }
    }
}


@Preview()
@Composable
fun PreviewPhrasePage() {
    PhrasesPage()
}