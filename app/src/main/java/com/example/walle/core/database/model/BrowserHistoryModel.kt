package com.example.walle.core.database.model

import androidx.room.Entity

@Entity(tableName = "browser_history")
data class BrowserHistoryModel(
    val url: String,
    val iconUrl: String,
)
