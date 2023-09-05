package com.example.walle.features.discover.presentation

import android.net.Uri
import android.provider.CalendarContract.Colors
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.walle.features.discover.domain.History
import java.util.Date

@Composable
fun HistoryItem(history: History, onTap: (() -> Unit)? = null) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color.Red)
            .let {
                if (onTap != null)
                    return@let Modifier.clickable(onClick = onTap)
                it
            }
    ) {


        AsyncImage(
            model = history.icon,
            contentDescription = history.name,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
        Box(modifier = Modifier.width(8.dp))
        Column {
            Text(history.name)
            Box(modifier = Modifier.height(8.dp))
            Text(history.url.toString())
        }
    }
}

@Preview
@Composable
fun Preview_HistoryItem() {
    HistoryItem(
        history = History(
            name = "SushiSwap",
            icon = Uri.parse("https://sushi.org/favicon.ico"),
            url = Uri.parse("https://sushi.org"),
            createdAt = Date(System.currentTimeMillis())
        )
    )
}