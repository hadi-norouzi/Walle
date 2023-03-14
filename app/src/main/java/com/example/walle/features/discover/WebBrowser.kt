package com.example.walle.features.discover

import android.os.Build
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebBrowser(navController: NavController, url: String) {

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(url, maxLines = 1, overflow = TextOverflow.Clip) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        }
    ) {
        AndroidView(
            factory = {
                WebView(context).apply {
                    webViewClient = WebViewClient()

                    settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
                    settings.blockNetworkLoads = false
                    loadUrl(url)
                }
            },
            modifier = Modifier.padding(it),
        )
    }
}